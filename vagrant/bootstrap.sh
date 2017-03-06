#!/usr/bin/env bash
sudo apt-get update
sudo apt-get install mc -y
sudo apt-get install -y software-properties-common python-software-properties

#java
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update
sudo apt-get install oracle-java8-installer
echo "Setting environment variables for Java 8.."
sudo apt-get install -y oracle-java8-set-default\

#kafka
wget http://ftp.ps.pl/pub/apache/kafka/0.10.2.0/kafka_2.12-0.10.2.0.tgz
tar -zxvf kafka_2.12-0.10.2.0.tgz
cd kafka_2.12-0.10.2.0
bin/zookeeper-server-start.sh config/zookeeper.properties&
bin/kafka-server-start.sh config/server.properties&