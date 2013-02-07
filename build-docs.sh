#!/bin/sh

git checkout gh-pages
rm -fr *
git checkout master docs
git reset head
mv docs/* .
rmdir docs
jekyll
git add -A
git commit -m "Generated gh-pages for `git log master -1 --pretty=short --abbrev-commit`"
git push origin gh-pages
git checkout master