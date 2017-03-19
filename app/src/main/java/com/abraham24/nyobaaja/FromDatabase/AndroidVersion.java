package com.abraham24.nyobaaja.FromDatabase;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KOCHOR on 2/21/2017.
 */
public class AndroidVersion {
    @SerializedName("hasil")
    public List<Children> listAndroid;

    public class Children {
        @SerializedName("id_konten")
        public String strid_blog;

        @SerializedName("judul_konten")
        public String strtitle_blog;

        @SerializedName("url_gambar")
        public String strurl_image;

        @SerializedName("id_kategori")
        public String idkategori;
    }
}
