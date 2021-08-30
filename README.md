# DesafioAPI
API para resolução do desafio Fullstack Zello

# Para rodar a aplicação

-> Clone o repositório 
-> Acesse o diretório do repositório clonado 
-> Troque a branch para master 
-> No terminal, execute o comando `mvn clean install` 
-> Execute o comando `mvn clean spring-boot:run` 
-> Acesse o endpoint http://localhost:8080/apps/ no postman ou insomnia para criar os apps, pois a aplicação não possui integração com banco de dados 
-> O modelo para a criação de apps é:
{
  "image": "https://i.pinimg.com/originals/bf/82/f6/bf82f6956a32819af48c2572243e8286.jpg",
  "icon": "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltbe08684abd48fe97/5fd2a7e97c43e43bf4196b8f/ValorantWallpaper_Icebox.jpg",
  "name": "Legends of Runeterra",
	"dev": "Riot",
	"tipo": "jogo"
}
-> após seguir esses passos, acesse https://github.com/luxcasgomes/DesafioPWAInterface para saber como executar a interface da aplicação
