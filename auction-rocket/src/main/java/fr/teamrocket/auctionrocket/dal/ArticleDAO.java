package fr.teamrocket.auctionrocket.dal;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;

public interface ArticleDAO {

	public abstract List<Article> listAll();
	
}
