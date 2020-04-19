export class Neighborhood {

    neighbId : number; 
    neighbName : string; 
    neighbRating : number; 
    neighbLoc : string; 
    popsqm : number; 
    avgprice : number; 
    hospital : number; 
    pow : number; 
    education : number; 
    grocery : number; 
    transit : number; 
    airports : number; 
    hotels : number; 
    pubsrv : number; 
    crmrate: number; 
    povrate : number; 
    homrate: number; 

    constructor ( neighbId: number, neighbName : string, neighbRating: number, neighbLoc: string, popsqm: number, avgprice: number, hospital: number, pow: number, education: number, grocery: number, transit: number, airports: number, hotels: number, pubsrv: number, crmrate: number, povrate: number, homrate: number){

        this.neighbId = neighbId; 
        this.neighbName =neighbName; 
        this.neighbRating = neighbRating; 
        this.neighbLoc = neighbLoc; 
        this.popsqm = popsqm; 
        this.avgprice = avgprice; 
        this.hospital = hospital; 
        this.pow = pow; 
        this.education = education; 
        this.grocery = grocery; 
        this.transit = transit; 
        this.airports = airports; 
        this.hotels = hotels; 
        this.pubsrv = pubsrv; 
        this.crmrate = crmrate;
        this.povrate = povrate; 
        this.homrate = homrate; 
        // this.crmrate = parseFloat(crmrate.toFixed(2)); 
        // this.povrate = parseFloat(povrate.toFixed(2)); 
        // this.homrate = parseFloat(homrate.toFixed(2)); 
    }
}