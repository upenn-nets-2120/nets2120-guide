## Using Git for Version Control

If you choose Visual Studio Code as your code editor, you will see a Source Control tab on the left sidebar, which is a GUI for Git operations. We still recommend you learn how to use Git commands in command line environments.

> **Note**: before you do your first git commit, you will need to configure git with your user information in your _Docker Container_. Use the following commands to do this:

```bash
git config --global user.email "you@seas.upenn.edu"
git config --global user.name "Your Name"
```

There are several Git commands that you will need to use in this course. When executing Git commands, the terminal’s current working directory should be inside your GitHub repo. Please read the linked guides for each command below:

- [git status](https://github.com/git-guides/git-status): shows which files have been modified and which files have been staged.
- git log: shows the commit history. Press `q` to exit.
- [git add](https://github.com/git-guides/git-add): adds files to the staging area.
- [git add -u](https://github.com/git-guides/git-add): looks for files that were previously part of the repository, and have been updated, and adds these to the staging area.
- [git commit](https://github.com/git-guides/git-commit): creates a "checkpoint" of the changes from the files that have been `git add`'d.
- [git push](https://github.com/git-guides/git-push): pushes local changes to the remote repository in GitHub.

If you need to undo an operations or changes you can use `git reset`, `git restore`, and `git revert`. The documentations linked above contains information on how to use these commands. Read them carefully to avoid losing your work.

