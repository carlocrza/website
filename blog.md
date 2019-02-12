---
layout: default
title:  "Blog Posts"
tags: jekyll update
---
hmmm I need to work on this...

![pusheen the cat](https://media1.tenor.com/images/4a950a1e221d93e654047ecee711af5a/tenor.gif?itemid=8105026)

<ul>
  {% for post in site.posts %}
    <li>
      <small>{{ post.date | date: "%-d %B %Y" }}</small><br>
      <a href="{{ post.url }}">{{ post.title }}</a>
      {{ post.excerpt }}
    </li>
  {% endfor %}
</ul>