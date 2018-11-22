package Classes;

import BD.Servicos;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas, arquivo criado dia 15/11/2018 às 20:25:45
 */
public class usuario {

    private Servicos serv;
    private funcoes f = new funcoes();
    private ArrayList<String> a;
    
    public usuario(Servicos serv) {
        this.serv = serv;
    }

    public void consulta(JTable jt, String nome, String tipo) {
        try {
            ArrayList<String> a = serv.Acao("SELECT nome, login, endereco, tipo_usuario FROM usuarios "
                    + "WHERE nome LIKE '%" + nome + "%' AND tipo_usuario"
                    + (tipo != null ? " <> 'administrador' AND tipo_usuario <> 'bibliotecario'" : " = '" + tipo + "'") + " GROUP BY tipo_usuario, nome, login, endereço ORDER BY nome ;");
            if (a != null) {
                DefaultTableModel mod = (DefaultTableModel) jt.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i), a.get(++i), a.get(++i), a.get(++i)});
                }
            }
        } catch (IndexOutOfBoundsException ioob) {
        }
    }

    public String pegaUsuario_id(String login) {
        try {
            return serv.Acao("SELECT id FROM usuarios WHERE login = '" + login + "';").get(0);
        } catch (IndexOutOfBoundsException ioob) {
            return "";
        }
    }

    public String cadastraUsuario(String login, String senha, String nome, String endereco, String tipo_usuario) {
        try {
            if (serv.Acao("INSERT INTO usuarios VALUES ('DEFAULT', '" + login + "', '" + f.encripta(senha) + "', '" + nome + "', '" + endereco + "', '" + tipo_usuario + "');") != null) {
                //JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
                try {Thread.sleep(100);} catch (InterruptedException ie) {}
                return serv.Acao("SELECT MAX(id) FROM usuarios;").get(0);
            } else
                return "0";
        } catch (IndexOutOfBoundsException ioob) {
            return "0";
        }
    }
    
    public void cadatraAluno(String usuario_id, String matricula, String data_ingresso, String data_conclusao, String cod_curso, JTable jtAlunos){
        if (serv.Acao("INSERT INTO alunos VALUES ('"+matricula+"', '"+f.converteDataJ2BD(data_ingresso)+"', '"+f.converteDataJ2BD(data_conclusao)+"', '"+cod_curso+"', '"+usuario_id+"');") != null)
            if (cadastraTelefonesAluno(usuario_id, jtAlunos))
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
    
    private boolean cadastraTelefonesAluno(String usuario_id, JTable jt){
        try{
            String sql = "INSERT INTO telefones_alunos VALUES ";
            for (int i = 0; i < jt.getRowCount(); i++) {
                sql += "('"+jt.getValueAt(i, 0)+"', '"+usuario_id+"')";
                if(i < jt.getRowCount()-1)
                    sql += ", ";
            }
            sql += ";";
            return serv.Acao(sql) != null;
        }catch(IndexOutOfBoundsException ioob){
            return false;
        }
    }
    
    public void cadatraProfessor(String usuario_id, String mat_siape, String telefone_celular, String regime_trabalho,String data_contratacao, String cod_curso){
        if (serv.Acao("INSERT INTO professores VALUES ('"+mat_siape+"', '"+telefone_celular+"', '"+regime_trabalho+"', '"+f.converteDataJ2BD(data_contratacao)+"', '"+cod_curso+"', '"+usuario_id+"');") != null)
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
    
    public void cadatraFuncionario(String usuario_id, String matricula, JTable jtFunc){
        if (serv.Acao("INSERT INTO funcionarios VALUES ('"+matricula+"', '"+usuario_id+"');") != null)
            if (cadastraTelefonesFuncionario(usuario_id, jtFunc))
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
    }
    
    private boolean cadastraTelefonesFuncionario(String usuario_id, JTable jt){
        try{
            String sql = "INSERT INTO telefones_funcionarios VALUES ";
            for (int i = 0; i < jt.getRowCount(); i++) {
                sql += "('"+jt.getValueAt(i, 0)+"', '"+usuario_id+"')";
                if(i < jt.getRowCount()-1)
                    sql += ", ";
            }
            sql += ";";
            return serv.Acao(sql) != null;
        }catch(IndexOutOfBoundsException ioob){
            return false;
        }
    }
    
    public boolean alteraUsuario(String usuario_id, String nome, String endereco, String senha){
        return serv.Acao("UPDATE usuarios SET nome = '"+nome+"', endereco = '"+endereco+"', senha = '"+f.encripta(senha)+"' WHERE id = '"+usuario_id+"';") != null;
    }
    
    private boolean apagarTelefonesAluno(String usuario_id){
        return serv.Acao("DELETE FROM telefones_alunos WHERE id_aluno = '"+usuario_id+"';") != null;
    }
    
    public void alteraTelefonesAluno(String usuario_id, JTable jt){
        if (apagarTelefonesAluno(usuario_id)){
            if (cadastraTelefonesAluno(usuario_id, jt))
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        }
    }
    
    public void alteraProfessor(String usuario_id, String celular){
        if(serv.Acao("UPDATE professores SET telefone_celular = '"+celular+"' WHERE id_usuario = '"+usuario_id+"';") != null)
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
    }
    
    private boolean apagarTelefonesFuncionarios(String usuario_id){
        return serv.Acao("DELETE FROM telefones_funcionarios WHERE id_funcionario = '"+usuario_id+"';") != null;
    }
    
    public void alteraTelefonesFuncionario(String usuario_id, JTable jt){
        if (apagarTelefonesFuncionarios(usuario_id)){
            if (cadastraTelefonesFuncionario(usuario_id, jt))
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        }
    }
    
    public String consultaUsuario(String usuario_id, JTextField tfNome, JTextField tfEndereco, JTextField tfLogin, JTextField tfSenha){
        try{
            a = serv.Acao("SELECT * FROM usuarios WHERE id = '"+usuario_id+"';");
            tfLogin.setText(a.get(1));
            tfSenha.setText(a.get(2));
            tfNome.setText(a.get(3));
            tfEndereco.setText(a.get(4));
            return a.get(5); //tipo_usuario
        }catch(IndexOutOfBoundsException ioob){
            return "";
        }
    }
    
    public void consultaAluno(String usuario_id, JTextField tfMat, JTextField tfDataIngresso, JTextField tfDataConclusao, JComboBox cbCurso, JTable jtAlunos){
        try{
            a = serv.Acao("SELECT (matricula, data_ingresso, data_conclusao, nome_curso) FROM (alunos NATURAL JOIN curso) WHERE id_usuario = '"+usuario_id+"';");
            tfMat.setText(a.get(0));
            tfDataIngresso.setText(a.get(1));
            tfDataConclusao.setText(a.get(2));
            cbCurso.setSelectedItem(a.get(3));
            a = serv.Acao("SELECT telefone_aluno FROM telefones_alunos WHERE id_funcionario = '"+usuario_id+"';");
            if(a != null){
                DefaultTableModel mod = (DefaultTableModel) jtAlunos.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i)});
                }
            }
        }catch(IndexOutOfBoundsException ioob){}
    }
    
    public void consultaProfessor(String usuario_id, JTextField tfSiape, JTextField tfDataContratacao, JTextField tfCelular, JComboBox cbCurso, JComboBox cbRegime){
        try{
            a = serv.Acao("SELECT (mat_siape, data_contratacao, telefone_celular, regime_trabalho, nome_curso) FROM (professor NATURAL JOIN curso) WHERE id_usuario = '"+usuario_id+"';");
            tfSiape.setText(a.get(0));
            tfDataContratacao.setText(a.get(1));
            tfCelular.setText(a.get(2));
            cbCurso.setSelectedItem(a.get(3));
            cbRegime.setSelectedItem(a.get(4));
        }catch(IndexOutOfBoundsException ioob){}
    }
    
    public void consultaFuncionario(String usuario_id, JTextField tfMat, JTable jtFuncionarios){
        try{
            a = serv.Acao("SELECT matricula FROM funcionario WHERE id_usuario = '"+usuario_id+"';");
            tfMat.setText(a.get(0));
            a = serv.Acao("SELECT telefone_funcionario FROM telefones_funcionarios WHERE id_funcionario = '"+usuario_id+"';");
            if(a != null){
                DefaultTableModel mod = (DefaultTableModel) jtFuncionarios.getModel();
                mod.setNumRows(0);
                for (int i = 0; i < a.size(); i++) {
                    mod.addRow(new Object[]{a.get(i)});
                }
            }
        }catch(IndexOutOfBoundsException ioob){}
    }
}
