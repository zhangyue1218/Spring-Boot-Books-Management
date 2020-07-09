package com.luna.demo.web;

import com.luna.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController

@RequestMapping("/v2")
public class HelloController {

//    @Autowired
//    private Book book;

    @PostMapping("/say")
    public String Hello(){
        return "Hello String Boot";
    }

    @GetMapping("/books")
//    @ResponseBody
    public Object getAll(@RequestParam("page") Integer page, @RequestParam(value = "size",defaultValue = "10") Integer size){
        Map<String, Object> book = new HashMap<>();
        book.put("name", "互联网世界观");
        book.put("isbn", "9877234623432");
        book.put("author", "李善友");
        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "程序员的思维修炼");
        book2.put("isbn", "12312312");
        book2.put("author", "auhi");

        List<Map> contents = new ArrayList<>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("content", contents);

        return pagemap;
    }

    /**
     * 正则表达式：{参数名:正则表达式} {username:[a-z_]+}
     * @param id
     * @return
     */
    @GetMapping("/books/{id}/{username}")
    public Object getOne(@PathVariable long id, @PathVariable String username) {
        System.out.println("id:"+ id + "username:" + username);
        return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam("name") String name,
                        @RequestParam("author") String author,
                        @RequestParam("isbn") String isbn){
        Map<String, Object> book = new HashMap<>();
        book.put("name", name);
        book.put("isbn", isbn);
        book.put("author",name);
        return book;
    }

}
