# Point 1

To create the workflow follow the commands below.

## List of command to make the point 1 using Linux and Git.
- git init
- touch README.md
- git add .
- git commit -m "init"
- git checkout -b hotfix
- touch hotfix.html
- git add hotfix.html 
- git commit -m "hotfix"
- git checkout master
- git merge hotfix -m "merge hotfix"
- git checkout -b feature1
- git checkout -b feature2
- git checkout feature1
- touch feature1.html
- git add .
- git commit -m "add feature1.html"
- git checkout feature2
- touch feature2.html
- git add .
- git commit -m "add feature2.html"
- git checkout master
- git merge feature1 -m "merge feature1"
- git merge feature2 -m "merge feature2"
- git status
