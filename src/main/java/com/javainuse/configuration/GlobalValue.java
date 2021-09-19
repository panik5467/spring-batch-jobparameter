package com.javainuse;

import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {

    public static String DATABASE;
    public static Set<String> GLOBALSET = new HashSet<>();

   @PostConstruct
   public void init() {
      for (String s : Set.of("AB-","CD-","EF"))
         GLOBALSET.add(s);
   }

    @Value("${mongodb.db}")
    public void setDatabase(String db) {
        DATABASE = db;
    }

    public void setList(Set<String> list) {
        GLOBALSET = list;
    }

    public Set<String> getList() {
        return GLOBALSET;
    }

}