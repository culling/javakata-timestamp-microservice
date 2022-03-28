/// <reference types="cypress" />

describe("canary", () => {
    it("should always be true", () => {
        expect(true).to.equal(true);
    })
})

describe('get from rest endpoint', () => {
    it("should get a valid response from timestamper/api/1451001600000", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api/1451001600000"
        cy.request(endpointUrl).then(response => {
            const body = response.body;
            expect(body.unix).to.equal(1451001600000);
            expect(body.utc).to.equal("Fri, 25 Dec 2015 00:00:00 GMT");
        });
    });

    it("should get a valid response from timestamper/api/1648449000000 ", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api/1648449000000"
        cy.request(endpointUrl).then(response => {
            const body = response.body;
            expect(body.unix).to.equal(1648449000000);
            expect(body.utc).to.equal("Mon, 28 Mar 2022 06:30:00 GMT");
        });
    });

    it("should get an error response from timestamper/api/apples ", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api/apples"
        cy.request(endpointUrl).then(response => {
            const body = response.body;
            expect(body.unix).to.equal(undefined);
            expect(body.utc).to.equal(undefined);
            expect(body.error).to.equal("Invalid Date");
        });
    });
});
