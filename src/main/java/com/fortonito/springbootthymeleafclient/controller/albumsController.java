package com.fortonito.springbootthymeleafclient.controller;

import com.fortonito.springbootthymeleafclient.response.AlbumRest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class albumsController {

    @GetMapping("/albums")
    public String getAlbums(Model model) {
        AlbumRest album = new AlbumRest();
        album.setAlbumId("one");
        album.setAlbumTitle("hhh");
        album.setAlbumUrl("https:localhost123");

        AlbumRest album2 = new AlbumRest();
        album.setAlbumId("two");
        album.setAlbumTitle("ddddd");
        album.setAlbumUrl("https:localhost178893");

        List<AlbumRest> returnValue = Arrays.asList(album, album2);

        model.addAttribute("albums", returnValue);
        return "albums";
    }
}
