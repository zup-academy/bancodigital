# bancodigital

## Criação de Conta 

```shell
curl --request POST \
  --url http://localhost:8080/contas \
  --header 'Content-Type: application/json' \
  --data '{
	"documentoTitular":35385638807,
	"nomeTitular":"Rafaela da Costa",
	"agencia":1000,
	"numero":123,
	"saldo":250
}'
```

## Transferência

```shell
curl --request POST \
  --url http://localhost:8080/transferencias \
  --header 'Content-Type: application/json' \
  --data '{
	"valor":200 ,
	"contaOrigem":{
		"agencia":1000,
		"numero":321
	},	
	"contaDestino":{
		"agencia":1000,
		"numero":123
	}
}'
```
