# bancodigital

## Solicitar Acesso AWS

Siga os passos conforme a seguinte doc:

https://github.com/zup-academy/materiais-publicos-treinamentos/blob/main/monitoria-e-tracing/acesso-aws.md

## Intalação

Antes de tudo é necessário que você tenha instalado em seu computador a AWS CLI.
Para saber como instalar, por favor siga os passos do link da documentação oficial de acordo com seu sistema operacional.

- https://docs.aws.amazon.com/pt_br/cli/latest/userguide/getting-started-install.html

É importante que você também tenha no seu computador instalado o terraform.
Para instalar siga os passos da documentação oficial de acordo com seu sistema operacional:

- https://learn.hashicorp.com/tutorials/terraform/install-cli

## Atualizando variáveis no projeto de infra

Clone o projeto na branch  

https://github.com/zup-academy/terraform-ec2-cloudwatch/tree/monitoria-e-tracing-tc3-tl1

- No o arquivo ec2.tf você irá alterar o campo ao final do arquivo tags e adicionará seu nome depois de "ec2"

```text
tags = {
  Name = "amazonlinux bancodigital ec2 Paula"
  }
```

- No arquivo cw_agent_config.json você irá alterar o nome do log_group_name adicionando seu nome ao final como no exemplo abaixo:

```text
   "log_group_name": "bancodigitalpaula"
```

## Executando esse projeto em uma instância da AWS

1- Acessar https://zup.awsapps.com/start#/

2- Escolher o "zup-edu-ot-sandbox" e clicar na opção  "Command line or programmatic access"

2- Copie os três primeiros dados de identificação

4- Acesse o projeto Terraforma e dentro do diretório você irá abrir o terminal e irá colar as credenciais que copiou da AWS.

6- Para criar a infraestrutura você deverá colocar no terminal o comando:

    make start

7- Após irá acessar o console da AWS pelo navegador, acessar o serviço EC2 e entrar na máquina identificada por amazonlinux bancodigital ec2 (seu nome)

8- clique no ID da instância , após do lado direito superior no botão connect, e depois session manager , opção connect.

9- ao acessar a máquina coloque:

    sudo su -

10- em seguida execute :

    bash -c 'cd /opt/bancodigital && git checkout monitoria-e-tracing-tc3-tl1'
    
11- Depois execute :

    docker-compose -f /opt/bancodigital/docker/docker-compose.yml up -d


12- Ao final das atividade é muito importante que você exclua a infraestrutura criada.
Você deverá acessar o projeto do Terraform e logar novamente no terminal com suas credenciais e depois colocar o comando.
    
    make stop
