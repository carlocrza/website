#!/bin/bash
#$1 = original (long) url
#$2 = new (short) url
cd '/Users/Carlo/Documents/website'
echo '---
layout: redirect
permalink: '"$2"'
redirect_to: '"$1"'
---' > "redirect/$2.md"
git add "redirect/$2.md"
git commit -m "Making shortcut: carloc.me/$2 --> $1"
git push origin master