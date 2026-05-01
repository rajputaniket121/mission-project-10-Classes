import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-scheduler-job-list',
  templateUrl: './scheduler-job-list.component.html',
  styles: [
  ]
})
export class SchedulerJobListComponent extends BaseListCtl {
  constructor(locator: ServiceLocatorService, route: ActivatedRoute) {
    super(locator.endpoints.SCHEDULERJOB, locator, route);
  }
}