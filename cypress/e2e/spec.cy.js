describe('empty spec', () => {
  it('passes', () => {
    cy.visit('http://localhost:8080/')
    /* ==== Generated with Cypress Studio ==== */
    cy.get('[onclick="background()"]').click();
    cy.get('#fname').click();
    cy.get('#lname').click();
    cy.get('#name').click();
    /* ==== End Cypress Studio ==== */
  })
})