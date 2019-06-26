package clinica.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clinica.controller.SecretariaController;
import clinica.model.Exame;
import clinica.model.dados.Repositorio;
import clinica.model.enums.ExameEnum;

public class CadastrarExameView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea obsGeral;
	private JComboBox<Object> classificacao;
	private JTextField nome;
	private Exame exam;
	private List<Object> exameslist = new ArrayList<Object>();
	private String[] classificacaoExame = {"Físico", "Laboratorial"};
	private JTextField duracao;
	private JTextField tmpResult;

	/**
	 * Create the frame.
	 */
	public CadastrarExameView(Repositorio repo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarExame = new JLabel("Cadastrar Exame");
		lblCadastrarExame.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarExame.setForeground(Color.BLACK);
		lblCadastrarExame.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastrarExame.setBounds(121, 42, 285, 34);
		contentPane.add(lblCadastrarExame);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(38, 109, 46, 14);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(81, 107, 164, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblObsGeral = new JLabel("Obs Geral:");
		lblObsGeral.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObsGeral.setBounds(10, 134, 66, 14);
		contentPane.add(lblObsGeral);
		
		obsGeral = new JTextArea();
		obsGeral.setLineWrap(true);
		obsGeral.setBounds(80, 134, 165, 69);
		contentPane.add(obsGeral);
		
		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o: ");
		lblDurao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDurao.setBounds(314, 110, 66, 14);
		contentPane.add(lblDurao);
		
		duracao = new JTextField();
		duracao.setColumns(10);
		duracao.setBounds(379, 107, 93, 20);
		contentPane.add(duracao);
		
		JLabel lblTempoPresultado = new JLabel("Tempo Result:");
		lblTempoPresultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTempoPresultado.setBounds(281, 143, 93, 14);
		contentPane.add(lblTempoPresultado);
		
		tmpResult = new JTextField();
		tmpResult.setColumns(10);
		tmpResult.setBounds(379, 141, 93, 20);
		contentPane.add(tmpResult);
		
		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o:");
		lblClassificao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClassificao.setBounds(281, 175, 93, 14);
		contentPane.add(lblClassificao);
		
		classificacao = new JComboBox<Object>(classificacaoExame);
		classificacao.setBounds(379, 173, 93, 20);
		contentPane.add(classificacao);
		
		JButton button = new JButton("Cadastrar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cadastrar(repo);
					JOptionPane.showMessageDialog(null, "Exame cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar o exame, verifique os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setBounds(226, 291, 109, 23);
		contentPane.add(button);
	}
	
	private void limparCampos() {
		nome.setText(null);
		obsGeral.setText(null);
		duracao.setText(null);
		tmpResult.setText(null);
	}
	
	private void cadastrar(Repositorio repo) {
		List<String> atributos;
		exam = new Exame();
		
		exam.setNome(nome.getText());
		exam.setObsGeral(obsGeral.getText());
		exam.setTempDuracao(duracao.getText());
		exam.setTempResultado(tmpResult.getText());
		
		if(classificacao.getSelectedItem().equals("Fisico")) {
			exam.setClassificacao(ExameEnum.FISICO);
		} else {
			exam.setClassificacao(ExameEnum.LABORATORIAL);
		}
		
		exameslist.add(exam);
		atributos = SecretariaController.gerarListaAtributosExame(exam);
		
		if(SecretariaController.validarDados(atributos)) {
			repo.setExamesCadastrados(exameslist);
		}		
	}
}
