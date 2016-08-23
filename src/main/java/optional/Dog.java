package optional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Igor Dmitriev on 8/20/16
 */
public class Dog {
    private Optional<Owner> owner; // плохо, owner по прежнему null, нет = new Optional.empty();
    private Optional<List<Owner>> owners = Optional.empty();  // да, и такое бывает

    public Optional<Owner> getOwner() {
        return owner;
    }

    public void setOwner(Optional<Owner> owner) {
        this.owner = owner;
    }

    public Optional<List<Owner>> getOwners() {
        return owners;
    }

    public void setOwners(Optional<List<Owner>> owners) {
        this.owners = owners;
    }
}
