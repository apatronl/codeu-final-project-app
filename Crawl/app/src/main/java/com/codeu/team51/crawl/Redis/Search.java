package com.codeu.team51.crawl.Redis;

import android.os.DropBoxManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static com.lexicalscope.jewel.cli.CliFactory.parseArguments;
import com.lexicalscope.jewel.cli.ArgumentValidationException;

import redis.clients.jedis.Jedis;

public class Search {

    private String[] terms;

    public Search(String[] terms) {
        this.terms = terms;
    }

    public ArrayList<String> performSearch() throws IOException {
        //creates a jedis object
        Jedis jedis = new Jedis("redis://redistogo:0e08f939c6607d58cc223043f31218c5@viperfish.redistogo.com:10617/");
        JedisIndex index = new JedisIndex(jedis);

        WikiSearch search1 = WikiSearch.search(terms[0], index);
        List<Entry<String, Integer>> entries = search1.sort();
        ArrayList<String> urls = new ArrayList<String>();
        for (Entry<String, Integer> entry: entries) {
            urls.add(entry.getKey());
            Log.d("Crawl", entry.getKey());
        }
        return urls;
    }
}
