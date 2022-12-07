package com.pfdevcon;

import static spark.Spark.*;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
        Pyramids pyramidsobj = new Pyramids();

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        get("/hello", (req, res) -> {
            res.type("aplication/jason");
            JSONObject jsonobj = new JSONObject(pyramidsobj);
            return jsonobj;
        });
        get("/hello/:id", (req, res) -> {
            res.type("application/json");
            JSONObject jsonobj = new JSONObject(pyramidsobj.getPyramid().get(Integer.parseInt(req.params(":id")) - 1));
            return jsonobj;});
        
        post("/hello", (req, res) -> {
            res.type("aplication/jason");
            Pyramid pyr = new Pyramid();
            JSONObject reqbody = new JSONObject(req.body());
            pyr.setPyramid(reqbody.getString("pyramid"));
            pyr.setRute(reqbody.getString("rute"));
            pyr.setId(pyramidsobj.getPyramid().size()+1);
            pyramidsobj.addPyramidlist(pyr);
            JSONObject numobj = new JSONObject(pyramidsobj);
            return numobj;
        });
    }

}
