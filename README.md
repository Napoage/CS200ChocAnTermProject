# demo
# Developing a Demo For The ChocAN Using Spring Boot Server, Java, Javascript, SQL, HTML, and Css to design a full stack interface.

Prerequisites:
- You must have Apache Maven 3.9.6 downloaded and it's bin folder added to Path in environment system variables
- You must have JDK version 17 installed and set as JAVA_HOME in environment system variables and it's bin folder added to Path
- You must have MySQL version 8.0.35 installed and setup with the full development stack
- You must have the following VSCode extensions installed: Oracle.mysql-shell-for-vs-code and formulahendry.vscode-mysql

Setup:
- While installing MySQL, set the username and password as "root", make sure the hostname is localhost and the port is 3306
- Once installed, a MySQL workbench should appear, in this workbench create a connection called "LocalConnection" with the hostname "localhost" and username and password both as "root"
- Once that connection has been created, open a command prompt and navigate to C:\Program Files\MySQL\MySQL Server 8.0\bin
- Type in this command:
mysql -u root -p
- It will prompt you for a password, you should enter "root" unless you set it as something different during install
- Use the command "\s" to check the connection, if it displays a connection id, the current user, the connection, and the tcp port then you should be connected properly
- If the connection displayed properly, then type in the following commands:
create database chocan;
create user 'user'@'%' identified by 'password';
grant all on chocan.* to 'user'@'%';

- Then, to connect to the database, type "\u chocan"
- Now in VSCode, install the extensions by the extension ids given above
- Clone this repo and navigate to the VSCode file explorer tab on the left hand sidebar. At the bottom of the left hand side explorer there should be several tabs along the lines of: Outline, Timeline, MySQL, Java Projects, Maven, ect.
- Click on MySQL and add a server by following the prompts at the top search bar on the screen, be sure to set hostname as "localhost" and the user as "root" or "user"
- Once the connection is added, it may display an error, this is not a problem as the connection still works
- Now in the MySQL shell for VS Code extension found on the left hand sidebar, go through the welcome page process and connect to the database
- Once connected to the database, add a connection called "LocalConnection" with the username and password as "root"

- You should be ready to run now!
