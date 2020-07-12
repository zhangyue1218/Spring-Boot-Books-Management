package com.luna.demo.web;

import com.luna.demo.domain.Book;
import com.luna.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class BookApp {

    @Autowired
    private BookService bookService;

    /**
     * 获取读书清单列表
     * @return
     */
//    @GetMapping("/books")
//    public List<Book> getAll() {
//        return bookService.findAll();
//    }
    @GetMapping("/books")
    public Page<Book> getAll(@PageableDefault(size = 5, sort ={"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return bookService.findAllByPage(pageable);
    }
    /**
     * 提交一个书单信息
     * @param book
     * @return
     */
    @PostMapping("/books")
    public Book post(Book book){
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
        return bookService.save(book);
    }

    /**
     * 获取一条书单
     * @param id
     * @return
     */
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id){
        return bookService.findOne(id);
    }

    /**
     * 更新一个书单
     * @param id
     * @param name
     * @param author
     * @param description
     * @param status
     * @return
     */
    @PutMapping("/books")
    public Book update(@RequestParam long id,
                       @RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setStatus(status);

        return bookService.save(book);
    }
    /**
     * 删除一个书单
     * @param id
     */
    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.delete(id);
    }

    @PostMapping("/books/by")
    public int findBy(@RequestParam long id, @RequestParam int status, @RequestParam long uid){
//        return bookService.findDescriptiponEndsWith(description);
//        return bookService.findbyJPQL(len);
//        return bookService.updatebyJPQL(status,id);
//        return bookService.deleteByJPQL(id);
        return bookService.deleteAndUpdate(id,status, uid);
    }



}
