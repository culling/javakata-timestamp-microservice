/// <reference types="cypress" />
// import adminUser from '../../../cypress/fixtures/users/adminUser.json';

describe('get from rest endpoint', () => {
    it("should login to jira", () => {
        const endpointUrl = Cypress.config().baseUrl + "/plugins/servlet/timestamper/api"
        cy.request(endpointUrl).then(response => {
            console.log(endpointUrl);
        });

    });
});
