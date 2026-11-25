# cadastroDeAgendamento
Desenvolvi um cadastro de agendamentos com interface desktop utilizando Java

## Banco de dados

O projeto usa MySQL e o driver Connector/J incluído em `ConnectSQL/`.
Configure as variáveis de ambiente antes de executar:

- `CADASTRO_DB_PASSWORD` (obrigatória): senha do usuário MySQL.
- `CADASTRO_DB_USER` (opcional; padrão `root`): usuário MySQL.
- `CADASTRO_DB_URL` (opcional; padrão `jdbc:mysql://localhost:3306/cadastro`): URL do banco.

Exemplo no Linux/macOS:

```sh
export CADASTRO_DB_USER=root
export CADASTRO_DB_PASSWORD='sua-senha'
```

Crie o banco `cadastro` no MySQL antes de iniciar o aplicativo.
