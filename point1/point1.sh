echo "Running commands to create the workflow of the point 1."
echo "You can go to the folder point1 and run the command 'git log -v' to see the workflow."
sudo mkdir point1
cd point1
git init
sudo touch README.md
git add .
git commit -m "init"
git checkout -b hotfix
sudo touch hotfix.html
git add hotfix.html 
git commit -m "hotfix"
git checkout master
git merge hotfix -m "merge hotfix"
git checkout -b feature1
git checkout -b feature2
git checkout feature1
sudo touch feature1.html
git add .
git commit -m "add feature1.html"
git checkout feature2
sudo touch feature2.html
git add .
git commit -m "add feature2.html"
git checkout master
git merge feature1 -m "merge feature1"
git merge feature2 -m "merge feature2"
git status