/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorios;

import conexoes.ConexaoPostgre;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.ModelConta;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Administrador
 */
public class DAORelatorios extends ConexaoPostgre{
    
    
    public boolean gerarRelatorioCliente() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioProdutos() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM produtos;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    public boolean gerarRelatorioFornecedores() {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM fornecedores;");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioFornecedores.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("select VENDAS.CODIGO as VENDASCODIGO\n"
                    + "     , VENDAS.CLIENTES_CODIGO as VENDASCLIENTES_CODIGO\n"
                    + "     , VENDAS.DATA_VENDA as VENDASDATA_VENDA\n"
                    + "     , VENDAS.VALOR_TOTAL as VENDASVALOR_TOTAL\n"
                    + "     , VENDAS.DESCONTO as VENDASDESCONTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO as VENDAS_PRODUTOCODIGO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_PRODUTO as VENDAS_PRODUTOCODIGO_PRODUTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_VENDA as VENDAS_PRODUTOCODIGO_VENDA\n"
                    + "     , VENDAS_PRODUTO.QUANTIDADE as VENDAS_PRODUTOQUANTIDADE\n"
                    + "     , PRODUTOS.CODIGO as PRODUTOSCODIGO\n"
                    + "     , PRODUTOS.NOME as PRODUTOSNOME\n"
                    + "     , PRODUTOS.VALOR as PRODUTOSVALOR\n"
                    + "     , CLIENTES.CODIGO as CLIENTESCODIGO\n"
                    + "     , CLIENTES.NOME as CLIENTESNOME\n"
                    + "     , CLIENTES.ENDERECO as CLIENTESENDERECO\n"
                    + "     , CLIENTES.BAIRRO as CLIENTESBAIRRO\n"
                    + "     , CLIENTES.CIDADE as CLIENTESCIDADE\n"
                    + "     , CLIENTES.UF as CLIENTESUF\n"
                    + "     , CLIENTES.CEP as CLIENTESCEP\n"
                    + "     , CLIENTES.TELEFONE as CLIENTESTELEFONE\n"
                    + "from VENDAS inner join VENDAS_PRODUTO on VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA\n"
                    + "inner join CLIENTES on VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO\n"
                    + "inner join PRODUTOS on VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("select VENDAS.CODIGO as VENDASCODIGO\n"
                    + "     , VENDAS.CLIENTES_CODIGO as VENDASCLIENTES_CODIGO\n"
                    + "     , VENDAS.DATA_VENDA as VENDASDATA_VENDA\n"
                    + "     , VENDAS.VALOR_TOTAL as VENDASVALOR_TOTAL\n"
                    + "     , VENDAS.DESCONTO as VENDASDESCONTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO as VENDAS_PRODUTOCODIGO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_PRODUTO as VENDAS_PRODUTOCODIGO_PRODUTO\n"
                    + "     , VENDAS_PRODUTO.CODIGO_VENDA as VENDAS_PRODUTOCODIGO_VENDA\n"
                    + "     , VENDAS_PRODUTO.QUANTIDADE as VENDAS_PRODUTOQUANTIDADE\n"
                    + "     , PRODUTOS.CODIGO as PRODUTOSCODIGO\n"
                    + "     , PRODUTOS.NOME as PRODUTOSNOME\n"
                    + "     , PRODUTOS.VALOR as PRODUTOSVALOR\n"
                    + "     , CLIENTES.CODIGO as CLIENTESCODIGO\n"
                    + "     , CLIENTES.NOME as CLIENTESNOME\n"
                    + "     , CLIENTES.ENDERECO as CLIENTESENDERECO\n"
                    + "     , CLIENTES.BAIRRO as CLIENTESBAIRRO\n"
                    + "     , CLIENTES.CIDADE as CLIENTESCIDADE\n"
                    + "     , CLIENTES.UF as CLIENTESUF\n"
                    + "     , CLIENTES.CEP as CLIENTESCEP\n"
                    + "     , CLIENTES.TELEFONE as CLIENTESTELEFONE\n"
                    + "from VENDAS inner join VENDAS_PRODUTO on VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA\n"
                    + "inner join CLIENTES on VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO\n"
                    + "inner join PRODUTOS on VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO where VENDAS.CODIGO = '" + pCodigo + "'");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPDV.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }
    
    public boolean gerarRelatorioContaReceber(int pCodigo) {
        try {
              this.conectar();
             this.executarSQL("SELECT * FROM clientes INNER JOIN contas ON clientes.CODIGO = contas.FK_CODIGO_PESSOA WHERE pk_codigo = '" + pCodigo + "';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM fornecedores INNER JOIN contas ON fornecedores.CODIGO = contas.FK_CODIGO_PESSOA WHERE pk_codigo = '"+pCodigo+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaPagar.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVendaData(Date pData) {
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes INNER JOIN vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO INNER JOIN tipo_pagamento ON vendas.TIPO_PAGAMENTO = tipo_pagamento.pk_codigo WHERE data_venda = '"+pData+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    public boolean gerarRelatorioVendaCliente(String pCliente) {
        
        try {
              this.conectar();
              this.executarSQL("SELECT * FROM clientes INNER JOIN vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO INNER JOIN tipo_pagamento ON vendas.TIPO_PAGAMENTO = tipo_pagamento.pk_codigo WHERE nome = '"+pCliente+"';");
              JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            return true;
    }

    /**
     * Gerar relatório de venda de uma conta a receber
     * @param pCodigo
     * @return 
     */
    public boolean gerarRelatorioContaVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     vendas.CODIGO AS vendas_CODIGO,\n"
                    + "     vendas.CLIENTES_CODIGO AS vendas_CLIENTES_CODIGO,\n"
                    + "     vendas.DATA_VENDA AS vendas_DATA_VENDA,\n"
                    + "     vendas.VALOR_TOTAL AS vendas_VALOR_TOTAL,\n"
                    + "     vendas.DESCONTO AS vendas_DESCONTO,\n"
                    + "     vendas.TIPO_PAGAMENTO AS vendas_TIPO_PAGAMENTO,\n"
                    + "     vendas_produto.CODIGO AS vendas_produto_CODIGO,\n"
                    + "     vendas_produto.CODIGO_PRODUTO AS vendas_produto_CODIGO_PRODUTO,\n"
                    + "     vendas_produto.CODIGO_VENDA AS vendas_produto_CODIGO_VENDA,\n"
                    + "     vendas_produto.QUANTIDADE AS vendas_produto_QUANTIDADE,\n"
                    + "     produtos.CODIGO AS produtos_CODIGO,\n"
                    + "     produtos.FORNECEDORES_CODIGO AS produtos_FORNECEDORES_CODIGO,\n"
                    + "     produtos.NOME AS produtos_NOME,\n"
                    + "     produtos.VALOR AS produtos_VALOR,\n"
                    + "     produtos.ESTOQUE AS produtos_ESTOQUE,\n"
                    + "     produtos.CODIGO_BARRAS AS produtos_CODIGO_BARRAS,\n"
                    + "     clientes.CODIGO AS clientes_CODIGO,\n"
                    + "     clientes.NOME AS clientes_NOME,\n"
                    + "     clientes.ENDERECO AS clientes_ENDERECO,\n"
                    + "     clientes.BAIRRO AS clientes_BAIRRO,\n"
                    + "     clientes.CIDADE AS clientes_CIDADE,\n"
                    + "     clientes.UF AS clientes_UF,\n"
                    + "     clientes.CEP AS clientes_CEP,\n"
                    + "     clientes.TELEFONE AS clientes_TELEFONE\n"
                    + "FROM\n"
                    + "     clientes clientes INNER JOIN vendas vendas ON clientes.CODIGO = vendas.CLIENTES_CODIGO\n"
                    + "     INNER JOIN vendas_produto vendas_produto ON vendas.CODIGO = vendas_produto.CODIGO_VENDA\n"
                    + "     INNER JOIN produtos produtos ON vendas_produto.CODIGO_PRODUTO = produtos.CODIGO "
                    + "WHERE vendas.CODIGO = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaVendasReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberDATA(ModelConta pModelConta) {
        String pCaminho = "";
        if (pModelConta.getTipoConta() == "RECEBER") {
            if (pModelConta.isSituacao() == 0) {
                pCaminho = "ArquivosJasper/relatorioReceber.jasper";
            } else {
                pCaminho = "ArquivosJasper/relatorioRecebidas.jasper";
        }
        }
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     contas.PK_CODIGO AS contas_PK_CODIGO,\n"
                    + "     contas.FK_CODIGO_PESSOA AS contas_FK_CODIGO_PESSOA,\n"
                    + "     contas.DESCRICAO AS contas_DESCRICAO,\n"
                    + "     contas.DATA AS contas_DATA,\n"
                    + "     contas.VENCIMENTO AS contas_VENCIMENTO,\n"
                    + "     contas.PAGAMENTO AS contas_PAGAMENTO,\n"
                    + "     contas.FK_TIPO_PAGAMENTO AS contas_FK_TIPO_PAGAMENTO,\n"
                    + "     contas.OBSERVACAO AS contas_OBSERVACAO,\n"
                    + "     contas.SITUACAO AS contas_SITUACAO,\n"
                    + "     contas.VALOR AS contas_VALOR,\n"
                    + "     contas.TIPO_CONTA AS contas_TIPO_CONTA,\n"
                    + "     clientes.CODIGO AS clientes_CODIGO,\n"
                    + "     clientes.NOME AS clientes_NOME,\n"
                    + "     clientes.ENDERECO AS clientes_ENDERECO,\n"
                    + "     clientes.BAIRRO AS clientes_BAIRRO,\n"
                    + "     clientes.CIDADE AS clientes_CIDADE,\n"
                    + "     clientes.UF AS clientes_UF,\n"
                    + "     clientes.CEP AS clientes_CEP,\n"
                    + "     clientes.TELEFONE AS clientes_TELEFONE\n"
                    + "FROM \n"
                    + "     contas contas INNER JOIN clientes clientes ON contas.FK_CODIGO_PESSOA = clientes.CODIGO WHERE pagamento = '" + pModelConta.getPagamento() + "'"
                    + " AND TIPO_CONTA = '" + pModelConta.getTipoConta()+ "' AND SITUACAO = '" + pModelConta.isSituacao()+ "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    public boolean gerarRelatorioContasPagarDATA(ModelConta pModelConta) {
        String pCaminho = "";
        if (pModelConta.getTipoConta() == "PAGAR") {
            if (pModelConta.isSituacao() == 0) {
                pCaminho = "ArquivosJasper/relatorioPagar.jasper";
            } else {
                pCaminho = "ArquivosJasper/relatorioPagas.jasper";
            }
        }
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     contas.PK_CODIGO AS contas_PK_CODIGO,\n"
                    + "     contas.FK_CODIGO_PESSOA AS contas_FK_CODIGO_PESSOA,\n"
                    + "     contas.DESCRICAO AS contas_DESCRICAO,\n"
                    + "     contas.DATA AS contas_DATA,\n"
                    + "     contas.VENCIMENTO AS contas_VENCIMENTO,\n"
                    + "     contas.PAGAMENTO AS contas_PAGAMENTO,\n"
                    + "     contas.FK_TIPO_PAGAMENTO AS contas_FK_TIPO_PAGAMENTO,\n"
                    + "     contas.OBSERVACAO AS contas_OBSERVACAO,\n"
                    + "     contas.SITUACAO AS contas_SITUACAO,\n"
                    + "     contas.VALOR AS contas_VALOR,\n"
                    + "     contas.TIPO_CONTA AS contas_TIPO_CONTA,\n"
                    + "     fornecedores.`CODIGO` AS fornecedores_CODIGO,\n"
                    + "     fornecedores.`NOME` AS fornecedores_NOME,\n"
                    + "     fornecedores.`ENDERECO` AS fornecedores_ENDERECO,\n"
                    + "     fornecedores.`BAIRRO` AS fornecedores_BAIRRO,\n"
                    + "     fornecedores.`CIDADE` AS fornecedores_CIDADE,\n"
                    + "     fornecedores.`UF` AS fornecedores_UF,\n"
                    + "     fornecedores.`CEP` AS fornecedores_CEP,\n"
                    + "     fornecedores.`TELEFONE` AS fornecedores_TELEFONE\n"
                    + "FROM\n"
                    + "     `contas` contas INNER JOIN `fornecedores` fornecedores ON contas.`FK_CODIGO_PESSOA` = fornecedores.`CODIGO`WHERE pagamento = '" + pModelConta.getPagamento() + "'"
                    + " AND TIPO_CONTA = '" + pModelConta.getTipoConta() + "' AND SITUACAO = '" + pModelConta.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberTODAS(ModelConta pModelConta) {
        String pCaminho = "";
        if (pModelConta.getTipoConta() == "RECEBER") {
            if (pModelConta.isSituacao() == 0) {
                pCaminho = "ArquivosJasper/relatorioReceber.jasper";
            } else {
                pCaminho = "ArquivosJasper/relatorioRecebidas.jasper";
        }
        }
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     contas.PK_CODIGO AS contas_PK_CODIGO,\n"
                    + "     contas.FK_CODIGO_PESSOA AS contas_FK_CODIGO_PESSOA,\n"
                    + "     contas.DESCRICAO AS contas_DESCRICAO,\n"
                    + "     contas.DATA AS contas_DATA,\n"
                    + "     contas.VENCIMENTO AS contas_VENCIMENTO,\n"
                    + "     contas.PAGAMENTO AS contas_PAGAMENTO,\n"
                    + "     contas.FK_TIPO_PAGAMENTO AS contas_FK_TIPO_PAGAMENTO,\n"
                    + "     contas.OBSERVACAO AS contas_OBSERVACAO,\n"
                    + "     contas.SITUACAO AS contas_SITUACAO,\n"
                    + "     contas.VALOR AS contas_VALOR,\n"
                    + "     contas.TIPO_CONTA AS contas_TIPO_CONTA,\n"
                    + "     clientes.CODIGO AS clientes_CODIGO,\n"
                    + "     clientes.NOME AS clientes_NOME,\n"
                    + "     clientes.ENDERECO AS clientes_ENDERECO,\n"
                    + "     clientes.BAIRRO AS clientes_BAIRRO,\n"
                    + "     clientes.CIDADE AS clientes_CIDADE,\n"
                    + "     clientes.UF AS clientes_UF,\n"
                    + "     clientes.CEP AS clientes_CEP,\n"
                    + "     clientes.TELEFONE AS clientes_TELEFONE\n"
                    + "FROM \n"
                    + "     contas contas INNER JOIN clientes clientes ON contas.FK_CODIGO_PESSOA = clientes.CODIGO WHERE "
                    + " TIPO_CONTA = '" + pModelConta.getTipoConta()+ "' AND SITUACAO = '" + pModelConta.isSituacao()+ "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasPagarTODAS(ModelConta pModelConta) {
        String pCaminho = "";
        if (pModelConta.getTipoConta() == "PAGAR") {
            if (pModelConta.isSituacao() == 0) {
                pCaminho = "ArquivosJasper/relatorioPagar.jasper";
            } else {
                pCaminho = "ArquivosJasper/relatorioPagas.jasper";
            }
        }
        try {
            this.conectar();
            this.executarSQL("SELECT\n"
                    + "     contas.PK_CODIGO AS contas_PK_CODIGO,\n"
                    + "     contas.FK_CODIGO_PESSOA AS contas_FK_CODIGO_PESSOA,\n"
                    + "     contas.DESCRICAO AS contas_DESCRICAO,\n"
                    + "     contas.DATA AS contas_DATA,\n"
                    + "     contas.VENCIMENTO AS contas_VENCIMENTO,\n"
                    + "     contas.PAGAMENTO AS contas_PAGAMENTO,\n"
                    + "     contas.FK_TIPO_PAGAMENTO AS contas_FK_TIPO_PAGAMENTO,\n"
                    + "     contas.OBSERVACAO AS contas_OBSERVACAO,\n"
                    + "     contas.SITUACAO AS contas_SITUACAO,\n"
                    + "     contas.VALOR AS contas_VALOR,\n"
                    + "     contas.TIPO_CONTA AS contas_TIPO_CONTA,\n"
                    + "     fornecedores.`CODIGO` AS fornecedores_CODIGO,\n"
                    + "     fornecedores.`NOME` AS fornecedores_NOME,\n"
                    + "     fornecedores.`ENDERECO` AS fornecedores_ENDERECO,\n"
                    + "     fornecedores.`BAIRRO` AS fornecedores_BAIRRO,\n"
                    + "     fornecedores.`CIDADE` AS fornecedores_CIDADE,\n"
                    + "     fornecedores.`UF` AS fornecedores_UF,\n"
                    + "     fornecedores.`CEP` AS fornecedores_CEP,\n"
                    + "     fornecedores.`TELEFONE` AS fornecedores_TELEFONE\n"
                    + "FROM\n"
                    + "     `contas` contas INNER JOIN `fornecedores` fornecedores ON contas.`FK_CODIGO_PESSOA` = fornecedores.`CODIGO` WHERE "
                    + " TIPO_CONTA = '" + pModelConta.getTipoConta() + "' AND SITUACAO = '" + pModelConta.isSituacao() + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}
