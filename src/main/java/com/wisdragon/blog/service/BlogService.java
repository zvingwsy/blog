package com.wisdragon.blog.service;

import java.util.Optional;

import com.wisdragon.blog.domain.Blog;
import com.wisdragon.blog.domain.Blog_Catalog;
import com.wisdragon.blog.domain.Sys_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Blog 服务接口.
 * 
 * @since 2018-06-12
 * @author zongxingh@163.com
 */
public interface BlogService {
	/**
	 * 保存Blog
	 * @param EsBlog
	 * @return
	 */
	Blog saveBlog(Blog blog);
	
	/**
	 * 删除Blog
	 * @param id
	 * @return
	 */
	void removeBlog(Long id);
	
	/**
	 * 根据id获取Blog
	 * @param id
	 * @return
	 */
	Optional<Blog> getBlogById(Long id);
 
	/**
	 * 根据用户进行博客名称分页模糊查询（最新）
	 * @param user
	 * @return
	 */
	Page<Blog> listBlogsByTitleVote(Sys_User user, String title, Pageable pageable);
 
	/**
	 * 根据用户进行博客名称分页模糊查询（最热）
	 * @param user
	 * @return
	 */
	Page<Blog> listBlogsByTitleVoteAndSort(Sys_User user, String title, Pageable pageable);

	/**
	 * 阅读量递增
	 * @param id
	 */
	void readingIncrease(Long id);
	
	/**
	 * 发表评论
	 * @param blogId
	 * @param commentContent
	 * @return
	 */
	Blog createComment(Long blogId, String commentContent);

	/**
	 * 删除评论
	 * @param blogId
	 * @param commentId
	 * @return
	 */
	void removeComment(Long blogId, Long commentId);
	
	/**
	 * 点赞
	 * @param blogId
	 * @return
	 */
	Blog createVote(Long blogId);

	/**
	 * 取消点赞
	 * @param blogId
	 * @param voteId
	 * @return
	 */
	void removeVote(Long blogId, Long voteId);

	/**
	 * 根据分类进行查询
	 * @param catalog
	 * @param pageable
	 * @return
	 */
	Page<Blog> listBlogsByCatalog(Blog_Catalog catalog, Pageable pageable);
 
}
