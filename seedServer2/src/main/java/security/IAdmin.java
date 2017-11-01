/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.util.List;

/**
 *
 * @author Troels
 */
public interface IAdmin {
    List<String>  getRolesAsStrings();
    String getPasswordHash();
    String getAdmin();
}

