package com.example.maccesarr.proyectomascotas.restApi;

/**
 * Created by MacCesarR on 01/02/17.
 */

public class ConstantesRestApi {

    //Esta clase es importante para poder definir nuestras costantes.
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL ="https://api.instagram.com"+VERSION;
    public static final String ACCESS_TOKEN = "4583320087.2ac9857.2089b5479d5e437ea4f997d40196dfa2";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_USER= "self";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/"+KEY_USER+"/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


    public static final String KEY_USER_ID= "4575231153";
    public static final String KEY_GET_RECENT_MEDIA_USER_ID = "users/{name}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER_ID = KEY_GET_RECENT_MEDIA_USER_ID+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN


    //self      Mi usuario
    //4575231153      Otro id de usuario

}
