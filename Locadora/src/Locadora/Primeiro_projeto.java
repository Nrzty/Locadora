package Locadoras;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Primeiro_projeto extends JFrame{
	
	private JButton btCadastroFilme;
	private JButton btConsultaFilme;
	private JButton btAlterarFilme;
	private JButton btExcluirFilme;
	
	private ArrayList<Locadoras> listaLocadoras;
	
	// FRONT DO SOFTWARE
	public Primeiro_projeto () {
		this.setTitle("LOCADORA!");
        setBounds(0,0,700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        btCadastroFilme = new JButton();
        btCadastroFilme.setText("Cadastrar Filme");
        btCadastroFilme.setBounds(10, 10, 150, 50);
        this.add(btCadastroFilme);
        
        btConsultaFilme = new JButton();
        btConsultaFilme.setText("Consultar Cidades");
        btConsultaFilme.setBounds(170, 10, 150, 50);
        this.add(btConsultaFilme);
        
        btAlterarFilme = new JButton();
        btAlterarFilme.setText("Alterar Filme");
        btAlterarFilme.setBounds(330, 10, 150, 50);
        this.add(btAlterarFilme);
        
        btExcluirFilme = new JButton();
        btExcluirFilme.setText("Excluir Filme");
        btExcluirFilme.setBounds(490, 10, 150, 50);
        this.add(btExcluirFilme);
        // FIM DO FRONT
        
        listaLocadoras = new ArrayList<Locadoras>();
        
        
        // CADASTRO DE FILME
        btCadastroFilme.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		Locadoras filmes = new Locadoras();
        		filmes.setCodigo(listaLocadoras.size()+1);
        		filmes.setNome(JOptionPane.showInputDialog("Informe O Nome Do Filme: "));
        		filmes.setAno(JOptionPane.showInputDialog("Informe O Ano Do Filme [dd/mm/yyyy]: "));
        		listaLocadoras.add(filmes);
        		JOptionPane.showMessageDialog(null, "Cadastro do Filme realizado com sucesso!", 
        				"Resultado", JOptionPane.INFORMATION_MESSAGE);
        	}
        }); // FIM DO CADASTRO DE FILME
        
        // CONSULTA DE FILME
        btConsultaFilme.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		
        	for (Locadoras filmes : listaLocadoras) {	
        		JOptionPane.showMessageDialog(null, "Filme: " + filmes.getNome() + 
        				"\n" + "Ano: " + filmes.getAno(), "Resultado",JOptionPane.INFORMATION_MESSAGE);
        	}
        	}
        }); // FIM DA CONSULTA DE FILME
        
      
        // ALTERAÇÃO DE FILME  
      btAlterarFilme.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	String nome = JOptionPane.showInputDialog("Nome");
        	
        	int indice = -1;
        	
        	for (int i = 0; i < listaLocadoras.size(); i++) {
        		Locadoras filmes = listaLocadoras.get(i);
        		if (nome.equalsIgnoreCase(filmes.getNome())) {
        			indice = i;
        		}
    		}
        	
        	if (indice == -1) {
        		
        		JOptionPane.showMessageDialog(null, "Esse Filme Não Existe!", 
        				"Alerta", JOptionPane.WARNING_MESSAGE);
        	} 
        	
        	else {
        		
        		Locadoras filmes = new Locadoras();
        		filmes.setNome(JOptionPane.showInputDialog("Informe o Novo Nome: "));
        		filmes.setAno(JOptionPane.showInputDialog("Informe o Novo Ano: "));
        		listaLocadoras.set(indice, filmes);
            	JOptionPane.showMessageDialog(null, "Filme alterada com sucesso!", 
            			"Resultado", JOptionPane.INFORMATION_MESSAGE);
        	}
        	
        }
    }); // FIM DA ALTERAÇÃO DO FILME
      
      
      // EXCLUSÃO DO FILME
      btExcluirFilme.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
          	
        	String nome = JOptionPane.showInputDialog("Informe O Nome Do Filme Que Você Deseja Excluir: ");
          	int indice = -1;
          	
          	for (Locadoras filmes : listaLocadoras) {            		
          		if (nome.equalsIgnoreCase(filmes.getNome())) {
          			indice = filmes.getCodigo();
          		}
			}
          	
          	if (indice == -1) {
          		JOptionPane.showMessageDialog(null, "Esse Filme Não Existe!", 
          				"Alerta", JOptionPane.WARNING_MESSAGE);
          	} else {
          		Locadoras filmes = new Locadoras();
              	listaLocadoras.remove(indice-1);
              	JOptionPane.showMessageDialog(null, "Filme excluido com sucesso!", 
              			"Resultado", JOptionPane.INFORMATION_MESSAGE);
          	}
          	
          }
      }); // FIM DA EXCLUSÃO DO FILME
      
      
	}	
	
	
	public static void main(String[] args) {
		 Primeiro_projeto form = new Primeiro_projeto();
		 form.setVisible(true);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
