# OCRbasket
Input an image, output text!

## Install Java
```bash
sudo apt install default-jdk    #Check version with: java -version
sudo apt install maven          #Check version with: mvn --version
```

## Clone project, compile and serve
```bash
git clone https://github.com/Perlesvaux/OCRbasket.git
cd OCRbasket/
mvn clean package 
java -jar target/basket-0.0.1-SNAPSHOT.jar 
```
### Each endpoint is a different implementation
http://localhost:8080/frompaste
http://localhost:8080/fromfile
