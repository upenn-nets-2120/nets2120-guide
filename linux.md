# Basic Linux Skills

In this class, you will mostly be working from the **Linux Terminal in VSCode** which should be running in your Container (after you have installed the Dev Containers extension and Attached to a Container).

Be careful to distinguish it from when you are running the Terminal on your host machine (Mac OS, Windows, Linux).  In general, we will assume any Terminal window outside VSCode is on your host machine and any terminal window inside VSCode is launched from the Dev Container.

* There are subtle differences between Terminal windows outside VSCode, and Ubuntu.  Mac OS resembles Linux but has some different commands.  Linux distributions other than Ubuntu may also differ.  Windows uses backslashes instead of slashes.
* We will try to share data between your host machine and the container (the `nets2120` directory). For the most part, you should be able to edit, compile, and test from either environment. **However you must always test your code running inside the container** so it is known to work on the correct Ubuntu environment.

## Navigating the Shell

### Command Commands

Within the Linux Terminal, you'll want to get comfortable with the following.

1. The `cd` (`chdir`) command changes directories to a path of your choice.
1. The `mkdir` command creates a new directory at the designated path.
1. The `ls` command lists the current directory (or a directory at a path of your choosing, e.g., `ls /`).  By default, any files or directories with a leading period, e.g., `.ssh`, are *hidden*. You can run `ls -a` to see *all* files / directories, including hidden ones.
1. The `cp` *{src} {dest}* command *copies* the *src* file/directory to the *dest* path.
1. The `mv` *{src} {dest}* command *moves* the *src* file/directory to the *dest* path.

If you want to end the Terminal you can enter `exit`.  If you ran the Terminal from VSCode you can simply delete the entry or close the window.

### Paths

All of the above commands use paths.  A path, on Linux and Mac OS, consists of a series of (optional) directories separated by `/` characters, followed by either a directory or file name (e.g., `/bin`, `my.file`). [On Windows, this is the same except that Windows uses the backslash `\` for the path separator.]

A special character, `*`, sometimes called a *wildcard* or a *glob*, can be used for the directory or filename at the *right end* of the path. This represents **all files or directories** within the specified path.

We always have a *current path*. By default on your VM this will be `/root/nets2120`.  On Mac it would be `/Users/`*{your-username}* and on Windows `\Users\`*{your-username}*.  On Linux it's usually `/home/`*{your-username}*.

We can specify other paths;
* A *leading* slash specifies that we go to the *file system root* (all objects in your computer will be somewhere in the tree below).  E.g., `/Applications` on the Mac, or `/usr/bin` on Linux, are paths starting from the root.  Paths with leading slashes are called **absolute paths**.
* A path without a leading slash is *relative* to our current directory.  This is called a **relative path**.
* The special directory `..` means the current directory's *parent*.  e.g., if we use `cd ..` from current directory `/root/nets2120` we will end up at `/root`.
* The special directory `.` means the current directory.  If we `cp /root/* .` this will copy all files from `/root` to the current directory. (Note that by default `cp` doesn't copy directories.)

