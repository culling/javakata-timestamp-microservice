/// <reference types="cypress" />

describe("canary", () => {
    it("should always be true", () => {
        expect(true).to.equal(true);
    })
})

describe('valid requests and responses from timestamper/api/:date?', () => {
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

});

describe('Empty time request from timestamper/api', ()=>{
    it("should get current time and date as response from timestamper/api ", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api";
        const milliseconds = new Date().getTime();
        const overlapTime = (1 * 60 * 1000);
        cy.request(endpointUrl).then(response => {
            const body = response.body;
            expect(body.unix).to.be.greaterThan(milliseconds - overlapTime);
            expect(body.unix).to.be.lessThan(milliseconds + overlapTime);

            expect(body.utc).to.equal((new Date(milliseconds)).toUTCString()); // Could flake, but an auto retry should resolve the issue
            expect(body.error).to.equal(undefined);
        });
    });
});


describe('invalid requests and responses from timestamper/api/:invalid_request?', ()=>{
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

