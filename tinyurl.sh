#!/bin/bash

cd '/Users/Carlo/Documents/ Webcoding Experiments/new_website/website'
bash redirect.sh $1 > $2
git add "$2.md"
git commit -m "Making shortcut: carloc.me/$2 --> $1"
git push origin master

