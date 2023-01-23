package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import transporte.Candidato;
import transporte.Questionario;

public class FrmResponderQuestionario extends JInternalFrame {
	
	private JLabel fdTitulo, fdCandidato, fdTema, fdAlterA, fdAlterB, fdAlterC, fdAlterD, fdPergunta, fdNumPergunta, fdNome1, fdTema1, fdTema2,
	fdCharA, fdCharB, fdCharC, fdCharD, fdFim, fdNota;
	private JComboBox comboCandidato, comboTema;
	private JButton btComecar, btProxima, btFinalizar, btVoltar;
	private JRadioButton btAlterA, btAlterB, btAlterC, btAlterD;
	private ButtonGroup buttonGroup;
	
	List<Questionario> listaQuestionarios;
	List<Candidato> listaCandidatos;
	FrmCadastrarCandidatos frmCadastrarCandidatos = new FrmCadastrarCandidatos();
	
	public FrmResponderQuestionario() {
			super("Responder Questionario", false, true, false, false);
		
		Container c = getContentPane();
		c.setLayout( null );
		
		Font fonte = new java.awt.Font("Comic Sans MS", 1, 20);
		Font fonteBt = new java.awt.Font("Comic Sans MS", 1, 14);
		listaQuestionarios = new ArrayList<Questionario>();
		listaCandidatos = new ArrayList<Candidato>();
		
		fdTitulo = new JLabel("RESPONDER QUESTIONARIO");
		fdTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
		c.add(fdTitulo);
		fdTitulo.setBounds(160,10,450,30);
		
		fdCandidato = new JLabel("Nome do candidato:");
		fdCandidato.setFont(fonte); 
		c.add(fdCandidato);
		fdCandidato.setBounds(80,70,220,30);
		
		fdTema = new JLabel("Tema do questionario:");
		fdTema.setFont(fonte); 
		c.add(fdTema);
		fdTema.setBounds(80,120,220,30);
		
		comboCandidato = new JComboBox(frmCadastrarCandidatos.buscaCandidatos());
		c.add(comboCandidato);
		comboCandidato.setBounds(280,70,220,30);
		
		comboTema = new JComboBox(frmCadastrarCandidatos.buscaQuestionarios());
		c.add(comboTema);
		comboTema.setBounds(300,120,220,30);
		
		btComecar = new JButton("Comecar");
		btComecar.setFont(fonte);
		c.add(btComecar);
		btComecar.setBounds(275,250,120,60);
		
		btProxima = new JButton("Proxima");
		btProxima.setFont(fonte);
		c.add(btProxima);
		btProxima.setBounds(275,300,120,60);
		btProxima.setVisible(false);
		
		btFinalizar = new JButton("Finalizar");
		btFinalizar.setFont(fonte);
		c.add(btFinalizar);
		btFinalizar.setBounds(275,300,120,60);
		btFinalizar.setVisible(false);
		
		btVoltar = new JButton("Voltar");
		btVoltar.setFont(fonte);
		c.add(btVoltar);
		btVoltar.setBounds(275,300,120,60);
		btVoltar.setVisible(false);
		
		fdNumPergunta = new JLabel("");
		fdNumPergunta.setFont(fonteBt); 
		c.add(fdNumPergunta);
		fdNumPergunta.setBounds(20,70,350,30);
		fdNumPergunta.setVisible(false);
		
		fdNome1 = new JLabel("aaaaaa");
		fdNome1.setFont(fonteBt); 
		c.add(fdNome1);
		fdNome1.setBounds(20,60,200,30);
		fdNome1.setVisible(false);
		
		fdTema1 = new JLabel("bbbbbb");
		fdTema1.setFont(fonteBt); 
		c.add(fdTema1);
		fdTema1.setBounds(200,60,200,30);
		fdTema1.setVisible(false);
		
		fdTema2 = new JLabel("bbbbbb");
		fdTema2.setFont(fonteBt); 
		c.add(fdTema2);
		fdTema2.setBounds(400,60,200,30);
		fdTema2.setVisible(false);
		
		fdFim = new JLabel("");
		fdFim.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
		c.add(fdFim);
		fdFim.setBounds(50,130,500,50);
		fdFim.setVisible(false);
		
		fdNota = new JLabel("");
		fdNota.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
		c.add(fdNota);
		fdNota.setBounds(50,180,500,50);
		fdNota.setVisible(false);
		
		
		
		fdPergunta = new JLabel("");
		fdPergunta.setFont(fonte); 
		c.add(fdPergunta);
		fdPergunta.setBounds(20,100,600,30);
		fdPergunta.setVisible(false);
		
		fdAlterA = new JLabel("");
		fdAlterA.setFont(fonteBt); 
		c.add(fdAlterA);
		fdAlterA.setBounds(20,130,350,30);
		fdAlterA.setVisible(false);
		
		fdAlterB = new JLabel("");
		fdAlterB.setFont(fonteBt); 
		c.add(fdAlterB);
		fdAlterB.setBounds(20,160,350,30);
		fdAlterB.setVisible(false);
		
		fdAlterC = new JLabel("");
		fdAlterC.setFont(fonteBt); 
		c.add(fdAlterC);
		fdAlterC.setBounds(20,190,350,30);
		fdAlterC.setVisible(false);
		
		fdAlterD = new JLabel("");
		fdAlterD.setFont(fonteBt); 
		c.add(fdAlterD);
		fdAlterD.setBounds(20,220,350,30);
		fdAlterD.setVisible(false);
		
		fdCharA = new JLabel("A");
		fdCharA.setFont(fonteBt); 
		c.add(fdCharA);
		fdCharA.setBounds(255,240,20,30);
		fdCharA.setVisible(false);
		
		fdCharB = new JLabel("B");
		fdCharB.setFont(fonteBt); 
		c.add(fdCharB);
		fdCharB.setBounds(305,240,20,30);
		fdCharB.setVisible(false);
		
		fdCharC = new JLabel("C");
		fdCharC.setFont(fonteBt); 
		c.add(fdCharC);
		fdCharC.setBounds(355,240,20,30);
		fdCharC.setVisible(false);
		
		fdCharD = new JLabel("D");
		fdCharD.setFont(fonteBt); 
		c.add(fdCharD);
		fdCharD.setBounds(405,240,20,30);
		fdCharD.setVisible(false);
		
		buttonGroup = new ButtonGroup();
		
		btAlterA = new JRadioButton("A");
		btAlterA.setFont(fonteBt);
		c.add(btAlterA);
		btAlterA.setBounds(250,260,20,30);
		buttonGroup.add(btAlterA);
		btAlterA.setVisible(false);
		
		btAlterB = new JRadioButton("A");
		btAlterB.setFont(fonteBt);
		c.add(btAlterB);
		btAlterB.setBounds(300,260,20,30);
		buttonGroup.add(btAlterB);
		btAlterB.setVisible(false);
		
		btAlterC = new JRadioButton("A");
		btAlterC.setFont(fonteBt);
		c.add(btAlterC);
		btAlterC.setBounds(350,260,20,30);
		buttonGroup.add(btAlterC);
		btAlterC.setVisible(false);
		
		btAlterD = new JRadioButton("A");
		btAlterD.setFont(fonteBt);
		c.add(btAlterD);
		btAlterD.setBounds(400,260,20,30);
		buttonGroup.add(btAlterD);
		btAlterD.setVisible(false);
		
		
		
		setSize(700,400);
		setVisible(true);
	}
	
	public void addComecarListener(ActionListener listenForComecarButton) {
		btComecar.addActionListener(listenForComecarButton);
	}	

	public void addProximaListener(ActionListener listenForProximaButton) {
		btProxima.addActionListener(listenForProximaButton);
	}	
	public void addFinalizarListener(ActionListener listenForFinalizarButton) {
		btFinalizar.addActionListener(listenForFinalizarButton);
	}	
	
	public void addVoltarListener(ActionListener listenForVoltarButton) {
		btVoltar.addActionListener(listenForVoltarButton);
	}	
	
	public void esconde_componentes(boolean mostra){
		fdCandidato.setVisible(mostra);		
		fdTema.setVisible(mostra);
		comboCandidato.setVisible(mostra);
		comboTema.setVisible(mostra);
		btComecar.setVisible(mostra);
		btFinalizar.setVisible(mostra);
		btProxima.setVisible(true);
		fdPergunta.setVisible(true);
		fdAlterA.setVisible(true);
		fdAlterB.setVisible(true);
		fdAlterC.setVisible(true);
		fdAlterD.setVisible(true);
		fdCharA.setVisible(true);
		fdCharB.setVisible(true);
		fdCharC.setVisible(true);
		fdCharD.setVisible(true);
		btAlterA.setVisible(true);
		btAlterB.setVisible(true);
		btAlterC.setVisible(true);
		btAlterD.setVisible(true);
		fdNome1.setVisible(true);
		fdTema1.setVisible(true);
		fdTema2.setVisible(true);

	}
	
	public void esconde_componentes2() {
		btProxima.setVisible(false);
		fdPergunta.setVisible(false);
		fdAlterA.setVisible(false);
		fdAlterB.setVisible(false);
		fdAlterC.setVisible(false);
		fdAlterD.setVisible(false);
		fdCharA.setVisible(false);
		fdCharB.setVisible(false);
		fdCharC.setVisible(false);
		fdCharD.setVisible(false);
		btAlterA.setVisible(false);
		btAlterB.setVisible(false);
		btAlterC.setVisible(false);
		btAlterD.setVisible(false);
		fdFim.setVisible(true);
		fdNota.setVisible(true);
	
	}
	
	public void esconde_componentes3() {
		fdNome1.setVisible(false);
		fdTema1.setVisible(false);
		fdTema2.setVisible(false);
		fdFim.setVisible(false);
		fdNota.setVisible(false);
		btVoltar.setVisible(false);
		comboCandidato.setVisible(true);
		comboTema.setVisible(true);
		btComecar.setVisible(true);
		fdCandidato.setVisible(true);
		fdTema.setVisible(true);
		
	}
	
	public String getPergunta() {
		return fdPergunta.getText();
	}
	
	public void setPergunta(String pergunta) {
		fdPergunta.setText(pergunta);
	}
	
	public String getAlterA() {
		return fdAlterA.getText();
	}
	
	public void setAlterA(String alterA) {
		fdAlterA.setText(alterA);
	}
	
	public String getAlterB() {
		return fdAlterB.getText();
	}
	
	public void setAlterB(String alterB) {
		fdAlterB.setText(alterB);
	}
	
	public String getAlterC() {
		return fdAlterC.getText();
	}
	
	public void setAlterC(String alterC) {
		fdAlterC.setText(alterC);
	}
	
	public String getAlterD() {
		return fdAlterD.getText();
	}
	
	public void setAlterD(String alterD) {
		fdAlterD.setText(alterD);
	}
	
	public String getNome1() {
		return fdNome1.getText();
	}
	
	public void setNome1(String nome1) {
		fdNome1.setText(nome1);
	}
	
	public String getTema1() {
		return fdTema1.getText();
	}
	
	public void setTema1(String tema1) {
		fdTema1.setText(tema1);
	}
	
	public String getTema2() {
		return fdTema2.getText();
	}
	
	public void setTema2(String tema2) {
		fdTema2.setText(tema2);
	}
	
	public String getComboNome() {
		
		return comboCandidato.getSelectedItem().toString();
		
	}
	
	public void setComboNome(String nome) {
		comboCandidato.setSelectedItem(nome);
	}
	
public String getComboTema() {
		
		return comboTema.getSelectedItem().toString();
		
	}
	
	public void setComboTema(String tema) {
		comboTema.setSelectedItem(tema);
	}
	
	public JButton getButtonProxima() {
		return btProxima;
	}
	
	public JButton getButtonFinalizar() {
		return btFinalizar;
	}
	
	public JButton getButtonVoltar() {
		return btVoltar;
	}
	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;	
	}
	
	


	public JRadioButton getBtAlterA() {
		return btAlterA;
	}

	public void setBtAlterA(JRadioButton btAlterA) {
		this.btAlterA = btAlterA;
	}

	public JRadioButton getBtAlterB() {
		return btAlterB;
	}

	public void setBtAlterB(JRadioButton btAlterB) {
		this.btAlterB = btAlterB;
	}

	public JRadioButton getBtAlterC() {
		return btAlterC;
	}

	public void setBtAlterC(JRadioButton btAlterC) {
		this.btAlterC = btAlterC;
	}

	public JRadioButton getBtAlterD() {
		return btAlterD;
	}

	public void setBtAlterD(JRadioButton btAlterD) {
		this.btAlterD = btAlterD;
	}
	
	public String getFim() {
		return fdFim.getText();
	}
	
	public void setFim(String fim) {
		fdFim.setText(fim);
	}
	
	public String getNota() {
		return fdNota.getText();
	}
	
	public void setNota(String nota) {
		fdNota.setText(nota);
	}
	
}

