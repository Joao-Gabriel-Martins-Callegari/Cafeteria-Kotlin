import kotlin.text.toIntOrNull
import kotlin.io.readln
import kotlin.io.println

fun main(){

    //Informando para o Kotlin explicitamente o tipo de minha List
    val lista = mutableListOf<MutableMap<String, Any>>(
        //Adicionando MutableMapOf para cada produto da Cafeteria
        mutableMapOf("nome" to "Cafe", "preco" to 4.50, "quantidade" to 10),
        mutableMapOf("nome" to "Pao", "preco" to 3.00, "quantidade" to 20),
        mutableMapOf("nome" to "Bolo", "preco" to 6.00, "quantidade" to 5)
     )

    //Declarando a variavel de input do usuário
    var opcao: Int 
    println("Olá! Seja bem Vindo a Cafeteria Kotlin")
    //Criando um laço de repetição para o menu do programa
    do{
        println() 
        //Imprimindo o menu
        println("1 - Listar Produtos")
        println("2 - Adicionar novo produto")
        println("3 - Realizar venda")
        println("4 - Repor estoque de produto existente")
        println("0 - Sair")

        //Pedindo o Input do usuário
        print("Escolha uma opção: ")
        //Caso o usuario digite um valor invalido
        //O programa definie -1 como valor padrão e continua a execução do programa
        opcao = readln().toIntOrNull() ?: -1
        println()  

        when(opcao){
            0 -> println("Saindo...") 
            1 -> listarProdutos(lista)
            2 -> adicionarProduto(lista)
            3 -> realizarVenda(lista)
            4 -> reporEstoque(lista) 
            else -> println("Opção inválida")
        }
    }while(opcao != 0)

    println("O programa foi encerrado.")

}

//Função para listar os produtos da Cafeteria
fun listarProdutos(produtos: MutableList<MutableMap<String, Any>>){
    println("\n---- LISTA DE PRODUTOS ----")
    for(produto in produtos){
        println("Nome: ${produto["nome"]}")
        println("Preço: R$ %.2f".format(produto["preco"]))
        println("Quantidade: ${produto["quantidade"]}")
        println()
    }
}

//Função para adicionar um novo produto a Cafeteria 
fun adicionarProduto(produtos: MutableList<MutableMap<String, Any>>){
    println("Digite os dados do novo produto:")
    print("Nome: ")
    val nome = readln()

    //Procurando se o produto já existe na lista de produtos para evitar itens repetidos 
    val produtoExistente = produtos.find { it["nome"].toString().equals(nome, ignoreCase = true)}
    if(produtoExistente != null){
        println("Produto já existe na Cafeteria")
        return
    }

    print("Preço: ")
    var preco = readln().toDoubleOrNull() ?: 0.0

    while(preco <= 0){
        println("Valor Invalido, tente novamente")
        print("Preço: ")
        preco = readln().toDoubleOrNull() ?: 0.0
    }

    print("Quantidade: ")
    var quantidade = readln().toIntOrNull() ?: 0

    while(quantidade <= 0){
        println("Valor Invalido, tente novamente")
        print("Quantidade: ")
        quantidade = readln().toIntOrNull() ?: 0
    }

    val novoProduto = mutableMapOf<String, Any>(
        "nome" to nome,
        "preco" to preco,
        "quantidade" to quantidade
    )

    produtos.add(novoProduto)
    println("Produto adicionado com sucesso!!!")
}

//Função para repor o estoque de um produto existente na Cafeteria
fun realizarVenda(produtos: MutableList<MutableMap<String, Any>>){

    print("Informe o nome do produto vendido: ")
    var nomeProduto = readln()
    //Procurando se o produto existe na lista de produtos
    val produto = produtos.find { it["nome"].toString().equals(nomeProduto, ignoreCase = true)}
    if(produto == null){
        println("Produto não encontrado")
        return
    }

    print("Quantas unidades foram vendidas: ")
    var qtdVendida = readln().toIntOrNull() ?: 0
    //Pegando a quantidade em estoque do produto
    var estoque = produto["quantidade"] as Int

    while(qtdVendida <= 0){
        println("Valor Invalido, tente novamente")
        print("Quantas unidades foram vendidas: ")
        qtdVendida = readln().toIntOrNull() ?: 0
    }

    //Se eu tenho estoque o suficiente
    if(qtdVendida <= estoque){
        //Se sim, subtraio a quantidade de vendas do meu estoque
        produto["quantidade"] = estoque - qtdVendida 
        //E informo que a venda foi realizada com sucesso
        println("Venda realizada com sucesso!!!")
    }else{
        //Caso contrario eu informo que a quantidade em estoque é insuficiente
        println("Quantidade insuficiente em estoque!")
    }
}

//Função de repor o estoque de um produto na Cafeteria
fun reporEstoque(produtos: MutableList<MutableMap<String, Any>>){
    
    print("Insira o nome do produto a ser reposto: ")
    var nomeProduto = readln()
    val produto = produtos.find { it["nome"].toString().equals(nomeProduto, ignoreCase = true)}
    //Procurando se o produto existe na lista de produtos
    if(produto != null){

        print("Informe a quantidade a repor: ")
        var qtdRepor = readln().toIntOrNull() ?: 0
        //Previnindo que o usuario digite um numero menor ou igual a 0
        while(qtdRepor <= 0){
            println("Você inseriu um valor invalido (letras, zero, negativo ou decimal.....)")
            print("Insira um valor válido:")
            qtdRepor = readln().toIntOrNull() ?: 0
        }
        var estoque = produto["quantidade"] as Int
        produto["quantidade"] = estoque + qtdRepor
        println("Produto reposto com sucesso!!!")

    }else{ //Se não existe eu pergunte se o usuario deseja adicionar o produto

        println("Este produto não existe")
        print("Deseja adiciona-lo como novo produto? (S/N)")
        var resposta = readln()
        if(resposta.equals("S", ignoreCase = true)){
            adicionarProduto(produtos)
        }else{
            return
        }
    }
}