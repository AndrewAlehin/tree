package com.example.tree;

import com.example.tree.model.Objects;
import com.example.tree.repository.ObjectsRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Html {

    private final ObjectsRepository repository;

    public Html(ObjectsRepository repository) {
        this.repository = repository;
    }

    public void create() {
        List<Objects> list = repository.getAll();
        StringBuilder html = new StringBuilder();
        createHtml(getTree(getRootElement(list), list, html), getStat(list));
    }

    private void createHtml(StringBuilder tree, StringBuilder stat) {
        File htmlTemplateFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\temple.html");
        try {
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            htmlString = htmlString.replace("$bodyTree", tree);
            htmlString = htmlString.replace("$bodyStat", stat);
            File newHtmlFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\index.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long getRootElement(List<Objects> list) {
        long min = Long.MAX_VALUE;
        for (Objects o : list) {
            long current = o.getParent_object_id();
            if (current < min)
                min = current;
        }
        return min;
    }

    private StringBuilder getTree(long id, List<Objects> objects, StringBuilder html) {
        StringBuilder result = new StringBuilder();
        for (Objects o : objects) {
            if (o.getParent_object_id() == id) {
                String name;
                try {
                    name = o.getData().getName();
                } catch (NullPointerException e) {
                    name = o.getUid();
                }
                result.append("<li>").append(name).append("</li>");
                getTree(o.getId(), objects, result);
            }
        }
        if (result.length() > 0)
            html.append("<ul>").append(result).append("</ul>");
        return html;
    }

    private StringBuilder getStat(List<Objects> list) {
        Map<Integer, Integer> stat = new HashMap<>();
        for (Objects o : list) {
            Integer key = o.getObject_type();
            int value = stat.get(key) == null ? 1 : stat.get(key) + 1;
            stat.put(key, value);
        }
        StringBuilder statHtml = new StringBuilder();
        statHtml.append("<ul>");
        stat.forEach((key, value) -> statHtml.append("<li>").append(key).append(": ").append(value).append("</li>"));
        statHtml.append("</ul>");
        return statHtml;
    }
}
