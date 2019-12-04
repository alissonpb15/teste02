package controller;

import model.ModelConta;
import DAO.DAOConta;
import java.sql.Date;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
*
* @author contato@blsoft.com.br
*/
public class ControllerConta {

    private DAOConta daoContaPagar = new DAOConta();
    private DAORelatorios daoRelatorios = new DAORelatorios();

    /**
    * grava ContaPagar
    * @param pModelContaPagar
    * return int
    */
    public int salvarContaPagarController(ModelConta pModelContaPagar){
        return this.daoContaPagar.salvarContaPagarDAO(pModelContaPagar);
    }

    /**
    * recupera ContaPagar
    * @param pCodigo
    * return ModelConta
    */
    public ModelConta getContaPagarController(int pCodigo){
        return this.daoContaPagar.getContaPagarDAO(pCodigo);
    }

    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaPagarController(){
        return this.daoContaPagar.getListaContaPagarDAO();
    }
    
    /**
    * recupera uma lista deContaPagar
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaPagarController(int pStatus){
        return this.daoContaPagar.getListaContaPagarDAO(pStatus);
    }
    
    /**
    * recupera uma lista deContaReceber
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaReceberController(int pStatus){
        return this.daoContaPagar.getListaContaReceberDAO(pStatus);
    }

    /**
    * recupera uma lista de todas as Contas 
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelConta> getListaContasController(int pStatus){
        return this.daoContaPagar.getListaContasDAO(pStatus);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelContaPagar
    * return boolean
    */
    public boolean atualizarContaPagarController(ModelConta pModelContaPagar){
        return this.daoContaPagar.atualizarContaPagarDAO(pModelContaPagar);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelContaReceber
    * return boolean
    */
    public boolean atualizarContaReceberController(ModelConta pModelContaReceber){
        return this.daoContaPagar.atualizarContaReceberDAO(pModelContaReceber);
    }

    /**
    * atualiza ContaReceber
    * @param pModelConta
    * return boolean
    */
    public boolean receberContaReceberController(ModelConta pModelConta){
        return this.daoContaPagar.receberContaReceberDAO(pModelConta);
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelConta
    * return boolean
    */
    public boolean pagarContaPagarController(ModelConta pModelConta){
        return this.daoContaPagar.pagarContaPagarDAO(pModelConta);
    }
    
    /**
    * exclui ContaPagar
    * @param pCodigo
    * return boolean
    */
    public boolean excluirContaPagarController(int pCodigo){
        return this.daoContaPagar.excluirContaPagarDAO(pCodigo);
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaReceber(pCodigo);
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaPagar(pCodigo);
    }

    public ArrayList<ModelConta> getListaContasController(ModelConta pModelConta) {
        return this.daoContaPagar.getListaContasDAO(pModelConta);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    /**
     * Gerar relatorio contas a pagar e a receber
     * @param modelConta
     * @return 
     */
    public boolean gerarRelatorioContasReceberDATA(ModelConta pModelConta) {
        return this.daoRelatorios.gerarRelatorioContasReceberDATA(pModelConta);
    }

    public boolean gerarRelatorioContasReceberTODAS(ModelConta pModelConta) {
        return this.daoRelatorios.gerarRelatorioContasReceberTODAS(pModelConta);
    }

    public boolean gerarRelatorioContasPagarDATA(ModelConta pModelConta) {
        return this.daoRelatorios.gerarRelatorioContasPagarDATA(pModelConta);
    }

    public boolean gerarRelatorioContasPagarTODAS(ModelConta pModelConta) {
        return this.daoRelatorios.gerarRelatorioContasPagarTODAS(pModelConta);
    }
    
}