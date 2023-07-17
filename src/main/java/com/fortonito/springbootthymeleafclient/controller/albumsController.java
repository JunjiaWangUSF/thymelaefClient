package com.fortonito.springbootthymeleafclient.controller;

import com.fortonito.springbootthymeleafclient.response.AlbumRest;
import com.nimbusds.openid.connect.sdk.token.OIDCTokens;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class albumsController {

    @GetMapping("/albums")
    //principal is open id authenticate user try to print principal to see more info
    // OidUser is a interface that extends Ouath2User and IdTokenAccessor
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {

        System.out.println("principle = " + principal);
        OidcIdToken idToken = principal.getIdToken();
        System.out.println("idToken value = " + idToken);

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
