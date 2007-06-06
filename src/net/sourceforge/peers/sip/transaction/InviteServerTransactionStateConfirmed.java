/*
    This file is part of Peers.

    Peers is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Peers is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
    
    Copyright 2007 Yohann Martineau 
*/

package net.sourceforge.peers.sip.transaction;

public class InviteServerTransactionStateConfirmed extends
        InviteServerTransactionState {

    public InviteServerTransactionStateConfirmed(String id,
            InviteServerTransaction inviteServerTransaction) {
        super(id, inviteServerTransaction);
    }

    @Override
    public void timerIFires() {
        InviteServerTransactionState nextState = inviteServerTransaction.TERMINATED;
        inviteServerTransaction.setState(nextState);
        log(nextState);
        // TODO destroy invite server transaction immediately
        // (dereference it in transaction manager serverTransactions hashtable)
        
        TransactionManager.getInstance().removeServerTransaction(
                inviteServerTransaction.branchId, inviteServerTransaction.method);
    }
    
}
