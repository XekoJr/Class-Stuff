#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int perfilMenu();
int escolha();
void escolhaInvalida();
int adminPIN();
int adminMenu();
void clienteID(char *email, char *id);
void registarCliente();
void adicionarRegistoCompras();
void trocarRegistoCompras();
void devolverRegistoCompras();
int clienteMenu();
int clientePIN(char id[]);
int criarPIN(char id[]);
void mostraRegisto(char id[]);
int adminEstatistica();
void clienteEstatistica(char email[]);

int main() {
    perfilMenu();
    return 0;
}

int perfilMenu() {
    int opcao;

    puts("\n\nBem vindo a nossa loja!\n");

    do
    {

    puts("\nEscolha o tipo de utilizador:");
    puts("1. Cliente");
    puts("2. Administrador");
    puts("3. Sair\n");        
    opcao = escolha();

    switch (opcao) {
        case 1 :
            //printf("Menu de cliente.");
            clienteMenu();
            break;
        case 2 :
            //printf("Menu de admin.");
            adminMenu();
            break;
        case 3 :
            printf("\nObrigado pela sua visita!\n\n");
            return 0;
            break;
        default:
            escolhaInvalida();
            break;
        }
    } while (opcao != 3);
}

int escolha() {
    int i;
    printf("Insira o numero correspondente a opcao desejada: ");
    scanf("%i", &i);
    return i;
}

void escolhaInvalida() {
    puts("\nEscolha invalida, tente novamente.");
}

int adminPIN() {
    int pin, i = 2, adminPINc = 1234;
    puts("\n\n---Menu de Admin---");

    for(i; i >= 0; i--) {
        printf("\nInserir PIN(4 digitos): ");
        scanf("%i", &pin);

        if (pin == adminPINc) {
            printf("\nPIN correto!\n\n");
            return 0;     
        } else {
            printf("PIN incorreto tente novamente, %i tentativas restantes.", i);
            if (i == 0) {
                printf("\n\nA voltar para o menu inicial.");
                return -1;
            }
        }
    }
}

int adminMenu() {
    int opcao;

        if (adminPIN() == -1)
    {
        return 0;
    }

    do
    {
    
    puts("\n----Menu de Administrador----\n");
    puts("1. Registar cliente");
    puts("2. Registar compra");
    puts("3. Trocar artigos");
    puts("4. Devolver artigos");
    puts("5. Dados de cliente");
    puts("6. Sair para o menu principal\n");
    opcao = escolha();
    
    switch (opcao) {
        case 1 :
            puts("\n--Registar cliente--\n");
            registarCliente();
            opcao = 10;
            break;
        case 2 :
            puts("\n--Adicionar Registo de Compra--\n");
            adicionarRegistoCompras();
            opcao = 10;
            break;
        case 3 :
            puts("\n--Troca de Compra--\n");
            trocarRegistoCompras();
            opcao = 10;
            break;
        case 4 :
            puts("\n--Devolucao de Compra--\n");
            devolverRegistoCompras();
            opcao = 10;
            break;
        case 5 :
            puts("\n--Dados Estatisticos--\n");
            adminEstatistica();
            opcao = 10;
            break;
        case 6 :
            puts("\nA voltar ao menu de perfil!\n");
            return 0;
        default:
            escolhaInvalida();
            break;
        }
    } while (opcao != 0);

    return opcao;
}

void clienteID(char email[], char id[]) {
    printf("Insira o email do cliente: ");
    scanf("%s", email);

    strcpy(id, email);
    strcat(id, ".txt");
}

// Função para registar um novo cliente
void registarCliente() {
    char email[40];
    char id[50];
    char nomeP[30], nomeA[30];
    int quantidade = 0;
    float media = 0, total = 0;

    clienteID(email, id);

    //Criar novo txt com o email do cliente como id
    FILE *f = fopen(id, "a+");

    fprintf(f, "    \nEmail: %s\n", email);
    printf("Qual o primeiro nome do cliente: ");
    scanf("%s", nomeP);
    printf("Qual o apelido do cliente: ");
    scanf("%s", nomeA);
    fprintf(f, "Nome: %s %s\n", nomeP, nomeA);
    
    fclose(f);

    //adicionar ao csv o novo cliente
    FILE *fr = fopen("dados.csv", "a+");

    fprintf(fr, "%s;%07.2f;%02d;%07.2f;\n", email, total, quantidade, media);
    fclose(fr);

    puts("O cliente foi registado com sucesso!");

}

// Função para criar um registo de compras
void adicionarRegistoCompras() {
    char email[40];
    char id[50];
    char artigo[50];
    float preco;
    int quantidade;
    float total = 0;
    char resposta;

    clienteID(email, id);

    // Adicionar ao ficheiro do cliente o registo de compra
    FILE *f = fopen(id, "a");
    if (f == NULL) {
        printf("Erro ao abrir o ficheiro do cliente.\n");
        return;
    }

    fprintf(f, "\nCompra efetuada:");

    do {
        printf("\nInsira o nome do artigo: ");
        scanf("%s", artigo);

        printf("Insira o preco do artigo: ");
        scanf("%f", &preco);

        printf("Insira a quantidade comprada: ");
        scanf("%i", &quantidade);

        total += preco * quantidade;

        fprintf(f, "\n%s, %.2f euros, %i", artigo, preco, quantidade);

        printf("Deseja adicionar mais artigos? (s/n): ");
        scanf(" %c", &resposta);

    } while (resposta == 's' || resposta == 'S');

    fprintf(f, "\nTotal: %.2f euros\n", total);

    fclose(f);

    printf("\nValor pago: %.2f euros\n", total);
    printf("Registo de compras efetuado!\n\n");
 
    // Adicionar ao ficheiro CSV os novos dados
    char emailFicheiro[100];
    int numeroCompras;
    float totalAnterior, totalFinal, media;

    FILE *fr = fopen("dados.csv", "r+");
    if (fr == NULL) {
        printf("Erro ao abrir o ficheiro csv para atualizar valores do cliente.\n");
        return;
    }

    // Ler as linhas do ficheiro CSV
    while (fscanf(fr, "%99[^;];%f;%2d;%f;\n", emailFicheiro, &totalAnterior, &numeroCompras, &media) == 4) {
        // Verificar se o email na linha é o email do cliente
        if (strcmp(emailFicheiro, email) == 0) {
            // Atualizar os valores do cliente

            totalFinal = totalAnterior + total;
            numeroCompras++;
            media = totalFinal / numeroCompras;

            // Reposicionar o cursor para o inicio da linha onde encontrou o cliente
            fseek(fr, -strlen(emailFicheiro) - 3 - 7 - 1 - 2 - 1 - 7 - 1, SEEK_CUR);                
            // Atualizar no ficheiro os valores do cliente
            fprintf(fr, "%s;%07.2lf;%02d;%07.2lf;\n", emailFicheiro, totalFinal, numeroCompras, media);
            break;
        }
    }

    fclose(fr);
}

// Função para efetuar uma troca no registo de compras
void trocarRegistoCompras() {
    char email[40];
    char id[50];
    char artigo[50];
    float preco;
    int quantidade;
    float totalAntigo = 0;
    float totalNovo = 0;
    char resposta;

    clienteID(email, id);

    FILE *f = fopen(id, "a");

    if (f == NULL) {
        printf("Erro ao abrir o ficheiro do cliente.\n");
        return;
    }

    fprintf(f, "\nTroca efetuda:");

    do {
        printf("\nInsira o nome do artigo a trocar: ");
        scanf("%s", artigo);

        printf("Insira o preco do artigo a trocar: ");
        scanf("%f", &preco);

        printf("Insira a quantidade a trocar: ");
        scanf("%i", &quantidade);

        totalAntigo += preco * quantidade;

        fprintf(f, "\n%s, %.2f euros, %i", artigo, preco, quantidade);

        printf("Deseja trocar mais artigos? (s/n): ");
        scanf(" %c", &resposta);

    } while (resposta == 's' || resposta == 'S');

    fprintf(f, "\nTrocado por:");

    do {
        printf("Insira o nome do artigo: ");
        scanf("%s", artigo);

        printf("Insira o preco do artigo: ");
        scanf("%f", &preco);

        printf("Insira a quantidade comprada: ");
        scanf("%i", &quantidade);

        totalNovo += preco * quantidade;

        fprintf(f, "\n%s, %.2f€, %i", artigo, preco, quantidade);

        printf("Deseja adicionar mais artigos? (s/n): ");
        scanf(" %c", &resposta);

    } while (resposta == 's' || resposta == 'S');

    if ((totalNovo -= totalAntigo) > 0) {
        fprintf(f, "\nTotal: %.2f euros\n", totalNovo);
        printf("\nValor pago: %.2f euros\n", totalNovo);
    } else {
        fprintf(f, "\nTotal de devolucao: %.2f euros\n", -(totalNovo));
        printf("\nValor devolvido: %.2f euros\n", -(totalNovo));
        }
    fclose(f);

    printf("Registo de troca efetuado!\n");

    // Atualizar do ficheiro CSV os novos dados
    char emailFicheiro[100];
    int numeroCompras;
    float totalAnterior, totalFinal, media;

    FILE *fr = fopen("dados.csv", "r+");
    if (fr == NULL) {
        printf("Erro ao abrir o ficheiro csv para atualizar valores do cliente.\n");
        return;
    }

    // Ler as linhas do ficheiro CSV
    while (fscanf(fr, "%99[^;];%f;%2d;%f;\n", emailFicheiro, &totalAnterior, &numeroCompras, &media) == 4) {
        // Verificar se o email na linha é o email do cliente
        if (strcmp(emailFicheiro, email) == 0) {
            // Atualizar os valores do cliente
            totalFinal = totalAnterior + totalNovo;
            media = totalFinal / numeroCompras;

            // Reposicionar o cursor para o inicio da linha onde encontrou o cliente
            fseek(fr, -strlen(emailFicheiro) - 3 - 7 - 1 - 2 - 1 - 7 - 1, SEEK_CUR);                
            // Atualizar no ficheiro os valores do cliente
            fprintf(fr, "%s;%07.2lf;%02d;%07.2lf;\n", emailFicheiro, totalFinal, numeroCompras, media);
            break;
        }
    }
    fclose(fr);

}

void devolverRegistoCompras() {
    char email[40];
    char id[50];
    char artigo[50];
    float preco;
    int quantidade;
    float total = 0;
    char resposta;

    clienteID(email, id);

    FILE *f = fopen(id, "a");

    if (f == NULL) {
        printf("Erro ao abrir o ficheiro do cliente.\n");
        return;
    }

    fprintf(f, "\nDevolução efetuda:");

    do {
        printf("\nInsira o nome do artigo a devolver: ");
        scanf("%s", artigo);

        printf("Insira o preco do artigo a devolver: ");
        scanf("%f", &preco);

        printf("Insira a quantidade a devolver: ");
        scanf("%i", &quantidade);

        total += preco * quantidade;

        fprintf(f, "\n%s, %.2f euros, %i", artigo, preco, quantidade);

        printf("Deseja devolver mais artigos? (s/n): ");
        scanf(" %c", &resposta);

    } while (resposta == 's' || resposta == 'S');

    fprintf(f, "\nTotal de devolucao: %.2f euros\n", total);

    fclose(f);

    printf("\nTotal de devolucao: %.2f euros\n", total);
    printf("\nRegisto de devolucao efetuado!\n");

    // Remover do ficheiro CSV os novos dados
    char emailFicheiro[100];
    int numeroCompras;
    float totalAnterior, totalFinal, media;

    FILE *fr = fopen("dados.csv", "r+");
    if (fr == NULL) {
        printf("Erro ao abrir o ficheiro csv para atualizar valores do cliente.\n");
        return;
    }

    // Ler as linhas do ficheiro CSV
    while (fscanf(fr, "%99[^;];%f;%2d;%f;\n", emailFicheiro, &totalAnterior, &numeroCompras, &media) == 4) {
        // Verificar se o email na linha é o email do cliente
        if (strcmp(emailFicheiro, email) == 0) {
            // Atualizar os valores do cliente

            totalFinal = totalAnterior - total;
            media = totalFinal / numeroCompras;

            // Reposicionar o cursor para o inicio da linha onde encontrou o cliente
            fseek(fr, -strlen(emailFicheiro) - 3 - 7 - 1 - 2 - 1 - 7 - 1, SEEK_CUR);                
            // Atualizar no ficheiro os valores do cliente
            fprintf(fr, "%s;%07.2lf;%02d;%07.2lf;\n", emailFicheiro, totalFinal, numeroCompras, media);
            break;
        }
    }
    fclose(fr);

}

//Mostra todos os dados do ficheiro CSV
int adminEstatistica() {  
    char emailFicheiro[100], tabela[10][4][100];
    int numeroCompras, i, j;
    float total, media;

    FILE *fr = fopen("dados.csv", "r");
    if (fr == NULL) {
        printf("Erro ao abrir o ficheiro csv.\n");
        return 1;
    }

    // Iniciar a tabela com strings vazias
    for (i = 0; i < 10; i++) {
        strcpy(tabela[i][0], "");
        strcpy(tabela[i][1], "");
        strcpy(tabela[i][2], "");
        strcpy(tabela[i][3], "");
    }

    // Ler as linhas do ficheiro CSV para a tabela
    i = 0;
    while ((fscanf(fr, "%99[^;];%f;%2d;%f;\n", emailFicheiro, &total, &numeroCompras, &media) == 4) != NULL ) {
        if (i < 10) {
            sprintf(tabela[i][0], "%s", emailFicheiro);
            sprintf(tabela[i][1], "%.2f", total);
            sprintf(tabela[i][2], "%d", numeroCompras);
            sprintf(tabela[i][3], "%.2f", media);

            i++;
        }
    }
    fclose(fr);

    // Escrever a tabela
    j = i;
    for (i=0; i<j; i++) {
        printf("Cliente: %s |Total Gasto: %s |Numero Compras: %s |Media por Compra: %s\n",
               tabela[i][0], tabela[i][1], tabela[i][2], tabela[i][3]);
    }

}

int criarPIN(char id[]) {
    int novoPIN;

    FILE *f = fopen(id, "r+");

    if (f == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 0;
    }

    printf("Insira um PIN de 4 dígitos: ");
    scanf("%4d", &novoPIN);

    fseek(f, 0, SEEK_SET); // Mover para o início do ficheiro

    fprintf(f, "%04d", novoPIN); // Substituir os 4 primeiros caracteres pelo novo PIN
    fclose(f);
    return novoPIN;
}

int clientePIN(char id[]) {
    char email[40];
    //char id[50];
    int numero, pin, i = 2;

    //clienteID(email, id);

    FILE *f = fopen(id, "r");

    if (f == NULL) {
        printf("Erro ao abrir o ficheiro do cliente.\n");
        return 1;
    }

    // Ler os 4 primeiros dígitos do ficheiro
    if (fscanf(f, "%4d", &numero) != 1) {
        printf("Deve definir o seu PIN antes de entrar.\n");
        fclose(f);

        numero = criarPIN(id);  // Passar o id como argumento
    }

    for(i ;i>=0;i--) {
        printf("Insira o pin: ");
        scanf("%i", &pin);
        if (pin == numero) {
            printf("\nPin Correto! Seja bem vindo!\n");
            return 0;
        }   else {
                printf("\nTente novamente, %i tentativas restantes\n", i);
                if(i==0) {
                    printf("\nTentativas excessivas..\n");
                    return -1;
                }
            }  
    }

    fclose(f);
    return 0;
}

int clienteMenu() {
    int opcao;
    char email[40];
    char id[50];

    puts("\n--Menu de Cliente--\n");
    clienteID(email, id);
    
    if (clientePIN(id) == -1)
    {
    return 0;
    }

    do
    {
    puts("\n--Menu de Cliente--\n");
    puts("1. Registo de compras");
    puts("2. Consultar dados");
    puts("3. Sair para o menu principal\n");        
    opcao = escolha();

    switch (opcao) {
        case 1 :
            puts("\n-Registo de Cliente-");
            mostraRegisto(id);
            break;
        case 2 :
            puts("\n-Estatisticas de Cliente-\n");
            clienteEstatistica(email);
            break;
        case 3 :
            printf("\nObrigado pela sua visita!\n\n");
            return 0;
            break;
        default:
            escolhaInvalida();
            break;
        }
    } while (opcao != 3);
}

void mostraRegisto(char id[]) {

    FILE *f = fopen(id, "r");

    if (f == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }

    char linha[1000];  // Ajuste o tamanho conforme necessário

    // Ler e ignorar as três primeiras linhas
    for (int i = 0; i < 3; ++i) {
        if (fgets(linha, sizeof(linha), f) == NULL) {
            printf("O cliente não tem qualquer compra registada.\n");
            fclose(f);
            return;
        }
    }

    // Imprimir o restante do arquivo
    while (fgets(linha, sizeof(linha), f) != NULL) {
        printf("%s", linha);
    }

    fclose(f);
    return;
}

void clienteEstatistica(char email[]) {
    
    // Adicionar ao ficheiro CSV os novos dados
    char emailFicheiro[100];
    int numeroCompras;
    float totalAnterior, totalFinal, media;

    FILE *fr = fopen("dados.csv", "r+");
    if (fr == NULL) {
        printf("Erro ao abrir o ficheiro csv para atualizar valores do cliente.\n");
        return;
    }

    // Ler as linhas do ficheiro CSV
    while (fscanf(fr, "%99[^;];%f;%2d;%f;\n", emailFicheiro, &totalAnterior, &numeroCompras, &media) == 4) {
        // Verificar se o email na linha é o email do cliente
        if (strcmp(emailFicheiro, email) == 0) {
               
            // Atualizar no ficheiro os valores do cliente
            printf("Ja gastou um total de %07.2lf euros na loja.\n", totalAnterior);
            printf("Efetuou um total de %02d compras.\n", numeroCompras);
            printf("Tem um valor medio de %07.2lf euros por compra.\n", media);
            break;
        }
    }

    fclose(fr);
}