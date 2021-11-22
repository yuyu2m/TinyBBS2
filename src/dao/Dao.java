package dao;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.List;import beans.Article;import beans.User;
public class Dao extends DriverAccessor{

	private Connection connection;
	public static final String UTF_8 = "UTF-8";	public static final String MS932 = "MS932";	public Dao(){
	}

	public User getUserById(String id) {		User user = new User();		this.connection = this.createConnection();
		try{
			String sql = "select * from user where id = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();			if(rs.first()){				user.setId( rs.getString("id") );				user.setPassword( rs.getString("password") );				user.setName( rs.getString("name") );				user.setEntryDatetime( rs.getDate("entry_datetime") );			}			else{				this.closeConnection(this.connection);				return null;			}

		}catch(SQLException e){
			this.closeConnection(this.connection);
			e.printStackTrace();			return null;

		} finally {			this.closeConnection(this.connection);
		}

		return user;
	}	public void insertUser(User user) {		this.connection= this.createConnection();		try{			String sql = "insert into user (id, password, name, entry_datetime) values(?, ?, ?, now())";			PreparedStatement stmt = this.connection.prepareStatement(sql);			stmt.setString(1, user.getId() );			stmt.setString(2, user.getPassword());			stmt.setString(3, user.getName());			stmt.executeUpdate();			stmt.close();			this.closeConnection(connection);		}catch(SQLException e){			this.closeConnection(connection);			e.printStackTrace();		} finally {			this.closeConnection(connection);		}	}	public Article getArticleById(int id) {		Article article = new Article();		this.connection = this.createConnection();		try{			String sql = "select * from article where id = ?";			PreparedStatement stmt = this.connection.prepareStatement(sql);			stmt.setInt(1, id);			ResultSet rs = stmt.executeQuery();			if(rs.first()){				article.setId( rs.getInt("id") );				article.setTitle( rs.getString("title") );				article.setBody( rs.getString("body") );				article.setEditorId( rs.getString("editor_id") );				article.setEntryDatetime( rs.getDate("entry_datetime") );			}			else{				this.closeConnection(this.connection);				return null;			}		}catch(SQLException e){			this.closeConnection(this.connection);			e.printStackTrace();			return null;		} finally {			this.closeConnection(this.connection);		}		return article;	}	public Article getNewestArticleByEditorId(String editorId) {		Article article = new Article();		this.connection = this.createConnection();		try{			String sql = "select * from article where editor_id = ? order by entry_datetime desc";			PreparedStatement stmt = this.connection.prepareStatement(sql);			stmt.setString(1, editorId);			ResultSet rs = stmt.executeQuery();			if(rs.first()){				article.setId( rs.getInt("id") );				article.setTitle( rs.getString("title") );				article.setBody( rs.getString("body") );				article.setEditorId( rs.getString("editor_id") );				article.setEntryDatetime( rs.getDate("entry_datetime") );			}			else{				this.closeConnection(this.connection);				return null;			}		}catch(SQLException e){			this.closeConnection(this.connection);			e.printStackTrace();			return null;		} finally {			this.closeConnection(this.connection);		}		return article;	}	public void insertArticle(Article article) {		this.connection= this.createConnection();		try{			String sql = "insert into article (title, body, editor_id, entry_datetime) values(?, ?, ?, now())";			PreparedStatement stmt = this.connection.prepareStatement(sql);			stmt.setString(1, article.getTitle());			stmt.setString(2, article.getBody());			stmt.setString(3, article.getEditorId());			stmt.executeUpdate();			stmt.close();			this.closeConnection(connection);		}catch(SQLException e){			this.closeConnection(connection);			e.printStackTrace();		} finally {			this.closeConnection(connection);		}	}	public List<Article> getArticleList() {		this.connection= this.createConnection();		List<Article> articleList = new ArrayList<Article>();		try{			String sql = "select * from article order by entry_datetime desc";			PreparedStatement stmt = this.connection.prepareStatement(sql);			ResultSet rs = stmt.executeQuery();			if(rs.first()){				do{					Article s = new Article( rs.getInt("id"), rs.getString("title"), rs.getString("body"), rs.getString("editor_id"), rs.getDate("entry_datetime") );					articleList.add(s);				}while(rs.next());			}		}catch(SQLException e){			this.closeConnection(connection);			e.printStackTrace();		} finally {			this.closeConnection(connection);		}		return articleList;	}
}

