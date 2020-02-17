#!/bin/bash

apt-get install virtualbox -y		# maquina virtual
apt-get install gnome-tweak-tool -y	# configurar aparencia do gnome
apt-get install vim -y		    	# editor de texto via terminal
apt-get install git -y		    	# gerenciador de versionamento
apt-get install qbittorrent -y  	# donwload de torrent
apt-get install wireshark -y    	# analisador de pacotes da rede
apt-get install calibre -y      	# editor e leitor de ebooks
apt-get install default-jdk -y		# pacote java atual

snap install code --classic	    	# editor de codigos vscode
snap install okular             	# leitor de PDF
snap install vlc 		        # reprodutor de video e musica
snap install audacity 		    	# edição de audio
snap install gimp 		        # composição de fotos
snap install darktable 	    		# editor de fotos
snap install inkscape 		    	# editor vetorial
#snap install xmind 		    	# mapa mental
#snap install kdenlive 		    	# editor de videos
#snap install obs-studio    		# gravador de tela


echo "baixando e atualizando os pacotes"
apt-get update && apt-get upgrade -y
echo "limpando cache"
apt autoremove && apt autoclean -y
echo "terminada a atualização"
