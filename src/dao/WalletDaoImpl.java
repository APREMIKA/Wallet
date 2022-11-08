//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dao;

import dto.Wallet;
import exception.WalletException;
import java.util.HashMap;
import java.util.Map;

public class WalletDaoImpl implements WalletDao {
    Map<Integer, Wallet> wallets = new HashMap();

    public WalletDaoImpl() {
    }

    public Wallet addWallet(Wallet newWallet) throws WalletException {
        this.wallets.put(newWallet.getId(), newWallet);
        return (Wallet)this.wallets.get(newWallet.getId());
    }

    public Wallet getWalletById(Integer walletId) throws WalletException {
        return (Wallet)this.wallets.get(walletId);
    }

    public Wallet updateWallet(Wallet updateWallet) throws WalletException {
        this.wallets.replace(updateWallet.getId(), updateWallet);
        return (Wallet)this.wallets.get(updateWallet.getId());
    }

    public Wallet deleteWalletById(Integer walletID) throws WalletException {
        if (!this.wallets.containsKey(walletID)) {
            throw new WalletException("Wallet Id does not exists to delete");
        } else {
            return (Wallet)this.wallets.remove(walletID);
        }
    }
}

