/// <reference types="cypress" />
// import adminUser from '../../../cypress/fixtures/users/adminUser.json';
describe("canary", () => {
    it("should always be true", () => {
        expect(true).to.equal(true);
    })
})

describe('get from rest endpoint', () => {
    it("should get a valid response from timestamper/api/:data?", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api/1451001600000"
        cy.request(endpointUrl).then(response => {
            const body = JSON.parse(response.body);
            console.log("body: ", body);
            expect(body.unix).to.equal(1451001600000);
            // expect(body.utc).to.equal("Fri, 25 Dec 2015 00:00:00 GMT");
            // expect(body).to.equal({
            //     unix: 1451001600000, utc: "Fri, 25 Dec 2015 00:00:00 GMT"
            // });
        });

    });
});
