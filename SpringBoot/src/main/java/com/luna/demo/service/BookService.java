package com.luna.demo.service;

import com.luna.demo.domain.Book;
import com.luna.demo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    /**
     * 查询所有的书单列表
     * @return
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    /**
     * 提交一个书单信息
     * @param book
     * @return
     */
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 获取一条书单信息
     * @param id
     * @return
     */
    public Optional<Book> findOne(long id) {
        return bookRepository.findById(id);
    }

    /**
     * 删除一条书单信息
     * @param id
     */
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    //没有方法就需要自定义

    /**
     * 根据Author查询书单列表
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByAuthorAndstatus(String author, int status){
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    public List<Book> findDescriptiponEndsWith(String description){
        return bookRepository.findByDescriptionContains(description);
    }

    public List<Book> findbyJPQL(int len){
        return bookRepository.findByJPQL(len);
    }

    @Transactional
    public int updatebyJPQL(int status, long id){
        return bookRepository.updateByJPQL(status, id);
    }

    /**
     * 自定义删除
     * @param id
     * @return
     */
    @Transactional
    public int deleteByJPQL(long id) {

        return bookRepository.deleteByJPQL( id);
    }

    /**
     * 测试事务操作
     * @param id
     * @param status
     * @param uid
     * @return
     */
//    @Transactional
    public int deleteAndUpdate(long id, int status, long uid) {
        int dcount = bookRepository.deleteByJPQL(id);
        int ucount = bookRepository.updateByJPQL(status, uid);
        return dcount+ucount;
    }


}
