package business_objects.car;

import java.util.List;

public class CarBuilder {

    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder withSuppliers(List<SuppliersOptions> suppliers) {
        car.setSuppliers(suppliers);
        return this;
    }

    public CarBuilder withSpecifications(List<CarSpecification> specifications) {
        car.setSpecifications(specifications);
        return this;
    }

    public CarBuilder withSupplierRatings(List<SupplierRating> raitings) {
        car.setSupplierRatings(raitings);
        return this;
    }

    public CarBuilder withSupplierLocations(List<SupplierLocation> locations) {
        car.setSupplierLocations(locations);
        return this;
    }

    public CarBuilder withFuelPolicies(List<FuelPolicy> fuelPolicies) {
        car.setFullToFull(fuelPolicies);
        return this;
    }

    public CarBuilder withPartySizes(List<PartySize> sizes) {
        car.setPartySizes(sizes);
        return this;
    }

    public CarBuilder withDamageExcesses(List<DamageExcess> excesses) {
        car.setDamageExcesses(excesses);
        return this;
    }

    public CarBuilder withDepositAtPickUps(List<DepositAtPickUp> depositAtPickUps) {
        car.setDepositAtPickUps(depositAtPickUps);
        return this;
    }

    public CarBuilder withPaymentCards(List<PaymentCard> paymentCards) {
        car.setPaymentCards(paymentCards);
        return this;
    }

    public CarBuilder withKilometres(List<Kilometres> kilometres) {
        car.setKilometres(kilometres);
        return this;
    }

    public Car build() {
        return car;
    }

    public class Car {

        private List<SuppliersOptions> suppliers;
        private List<CarSpecification> specifications;
        private List<SupplierRating> supplierRatings;
        private List<SupplierLocation> supplierLocations;
        private List<FuelPolicy> fuelPolicies;
        private List<PartySize> partySizes;
        private List<DamageExcess> damageExcesses;
        private List<DepositAtPickUp> depositAtPickUps;
        private List<PaymentCard> paymentCards;
        private List<Kilometres> kilometres;

        private Car() {
        }

        public void setSuppliers(List<SuppliersOptions> suppliers) {
            this.suppliers = suppliers;
        }

        public void setSpecifications(List<CarSpecification> specifications) {
            this.specifications = specifications;
        }

        public void setSupplierRatings(List<SupplierRating> supplierRatings) {
            this.supplierRatings = supplierRatings;
        }

        public void setSupplierLocations(List<SupplierLocation> supplierLocations) {
            this.supplierLocations = supplierLocations;
        }

        public void setFullToFull(List<FuelPolicy> fuelPolicies) {
            this.fuelPolicies = fuelPolicies;
        }

        public void setPartySizes(List<PartySize> partySizes) {
            this.partySizes = partySizes;
        }

        public void setDamageExcesses(List<DamageExcess> damageExcesses) {
            this.damageExcesses = damageExcesses;
        }

        public void setDepositAtPickUps(List<DepositAtPickUp> depositAtPickUps) {
            this.depositAtPickUps = depositAtPickUps;
        }

        public void setPaymentCards(List<PaymentCard> paymentCards) {
            this.paymentCards = paymentCards;
        }

        public void setKilometres(List<Kilometres> kilometres) {
            this.kilometres = kilometres;
        }

        public List<SuppliersOptions> getSuppliers() {
            return suppliers;
        }

        public List<CarSpecification> getSpecifications() {
            return specifications;
        }

        public List<SupplierRating> getSupplierRatings() {
            return supplierRatings;
        }

        public List<SupplierLocation> getSupplierLocations() {
            return supplierLocations;
        }

        public List<FuelPolicy> getFuelPolicies() {
            return fuelPolicies;
        }

        public List<PartySize> getPartySizes() {
            return partySizes;
        }

        public List<DamageExcess> getDamageExcesses() {
            return damageExcesses;
        }

        public List<DepositAtPickUp> getDepositAtPickUps() {
            return depositAtPickUps;
        }

        public List<PaymentCard> getPaymentCards() {
            return paymentCards;
        }

        public List<Kilometres> getKilometres() {
            return kilometres;
        }
    }


}

