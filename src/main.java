import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class main {

	public static void main(String[] args) throws IOException {
		//Saida do arquivo
		OutputStream fos = new FileOutputStream("vendas.csv");//saida do arquivo
		Writer osw = new OutputStreamWriter(fos);//escrita no arquivo
		BufferedWriter bw = new BufferedWriter(osw);
		//Saida do Arquivo
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Insira a margem de lucro: ");
			int margem = reader.read();
			String line = "";
			while(line != null) {
				//código
				System.out.print("Insira o codigo do produto: ");			
				int codigo = reader.read();
				
				//nome
				System.out.println("Insira o nome do produto: ");
				String name = reader.readLine();
				
				//preço
				System.out.println("Insira o preço do produto: ");
				int pre = reader.read();
				double preco = lucroDoProduto(margem, pre);
				
				System.out.println("Insira a quantidade no estoque: ");
				int estoque = reader.read();
				
				//categoria
				System.out.println("Insira o categoria do produto: ");
				String categoria = reader.readLine();
				
				
				//concatena variaveis a variavel linha
				String linha = codigo + ";;" + estoque + ";;" + name + ";;" + preco + ";;" + categoria;
				//System.out.println(linha);
				bw.write(linha); //escrece na linha
				bw.newLine();//poxima linha
			}
			
		}catch(Exception e) {
			System.out.printf("Error opening file. \n", e.getMessage());
		}finally {
			bw.close();
		}
	}
	public static double lucroDoProduto(int marg, int pre) {
		double porcetagemDeLucro = (marg * 100) / pre;
		return (pre + porcetagemDeLucro);
	}
}

// [x] Criar saida de arquivo csv
// [x] Código - nome - preço - categoria 
// [x] Solicitar margem de lucro sobre produto
// [ ] Saida deve ser codigo - estoque - nome - preço - categoria