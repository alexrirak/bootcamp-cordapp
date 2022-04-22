package com.bootcamp.states;

import com.bootcamp.contracts.TokenContract;
import lombok.Builder;
import lombok.Getter;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/* Our state, defining a shared fact on the ledger.
 * See src/main/java/examples/ArtState.java for an example. */
@BelongsToContract(TokenContract.class)
@Getter
public class TokenState implements ContractState {

    private Party issuer;
    private Party owner;
    private int amount;

    private String currencyCode;

    private List<AbstractParty> participants;

    public TokenState(Party issuer, Party owner, int amount, String currencyCode) {
        this.issuer = issuer;
        this.owner = owner;
        this.amount = amount;
        this.currencyCode = currencyCode;

        this.participants = new ArrayList<>();
        this.participants.add(issuer);
        this.participants.add(owner);
    }
}