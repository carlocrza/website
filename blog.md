---
layout: default
title:  "Blog Posts"
tags: jekyll update
---
Click the blog links to read more!

`THIS PAGE IS UNDER CONSTRUCTION`

<ul>
  {% for post in site.posts %}
    <li>
      <small>{{ post.date | date: "%-d %B %Y" }}</small><br>
      <a href="{{ post.url }}">{{ post.title }}</a>
      {{ post.excerpt }}
    </li>
  {% endfor %}
</ul>